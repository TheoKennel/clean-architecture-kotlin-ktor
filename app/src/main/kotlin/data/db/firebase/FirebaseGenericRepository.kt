package data.db.firebase

import com.google.firebase.database.*
import domain.models.CustomDex
import utils.Constants
import javax.inject.Singleton

@Singleton
class FirebaseGenericRepository<T>(private val clazz: Class<T>) {

    private val userReference: DatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.DB_USER)

    fun getAll(callback: (List<T>?, Exception?) -> Unit) {
        fetchFromFirebase(userReference, ::parseListValue, callback)
    }

    fun get(userId: String, callback: (T?, Exception?) -> Unit) {
        val ref = userReference.child(userId)
        fetchFromFirebase(ref, ::parseSingleValue, callback)
    }

    fun save(userId: String, data: T, callback: (Boolean, Exception?) -> Unit) {
        val userRef = userReference.child(userId)
        saveWithValueEventListener(userRef, data, callback)
    }


    fun update(userId: String, data: T, callback: (Boolean, Exception?) -> Unit) {
        val ref = userReference.child(userId)
        saveWithValueEventListener(ref, data, callback)
    }

    fun delete(userId: String, callback: (Boolean, Exception?) -> Unit) {
        val userRef = userReference.child(userId)
        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    userRef.removeValue { error, _ ->
                        if (error == null) {
                            callback(true, null)
                        } else {
                            callback(false, error.toException())
                        }
                    }
                } else {
                    callback(false, Exception("User does not exist."))
                }
            }
            override fun onCancelled(error: DatabaseError) {
                callback(false, error.toException())
            }
        })
    }

    fun saveChild(parentId: String, childPath: String, item: T, callback: (Boolean, Exception?) -> Unit) {
        val ref =  userReference.child(parentId).child(childPath)
        saveWithValueEventListener(ref, item, callback)
    }

    fun saveChildList(parentId: String, firstChildPath: String, items: List<T>, callback: (Boolean, Exception?) -> Unit) {
            val ref =  userReference.child(parentId).child(firstChildPath)
            ref.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot?) {
                    ref.setValue(items) { error, _  ->
                        if (error != null) {
                            callback(true, error.toException())
                        } else {
                            callback(false, null)
                        }

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    callback(false, error.toException())
                }
            })
    }

    fun saveChildOfChildByDexName(
        parentId: String,
        firstChildPath: String,
        secondChildId: String,
        item: T,
        dexName: String,
        callback: (Boolean, Exception?) -> Unit
    ) {
        val ref = userReference.child(parentId).child(firstChildPath).child(secondChildId)
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    val existingItem = child.getValue(clazz)
                    if (existingItem != null && (existingItem as CustomDex).name == dexName) {
                        child.ref.setValue(item) { error, _ ->
                            if (error != null) {
                                callback(false, error.toException())
                            } else {
                                callback(true, null)
                            }
                        }
                        return
                    }
                }
                callback(false, Exception("No matching item found for dexName: $dexName"))
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, error.toException())
            }
        })
    }


    fun getChild(userId : String, childPath: String, callback: (T?, Exception?) -> Unit) {
        val ref = userReference.child(userId).child(childPath)
        fetchFromFirebase(ref, ::parseSingleValue, callback)
    }

    fun getChildOfChildList(userId : String, childPath: String, secondChildPath: String, callback: (List<T>?, Exception?) -> Unit) {
        val ref = userReference.child(userId).child(childPath).child(secondChildPath)
        fetchFromFirebase(ref, ::parseListValue, callback)
    }

    fun getCustomDexByDexName(
        userId: String,
        childPath: String,
        secondChildId: String,
        dexName: String,
        callback: (T?, Exception?) -> Unit
    ) {
        val ref = userReference.child(userId).child(childPath).child(secondChildId)
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    var result: T? = null
                    for (child in snapshot.children) {
                        val item = child.getValue(clazz)
                        if (item != null && item is CustomDex && item.name == dexName) {
                            result = item
                            break
                        }
                    }
                    if (result != null) {
                        callback(result, null)
                    } else {
                        callback(null, Exception("No matching item found for dexName: $dexName"))
                    }
                } catch (e: Exception) {
                    callback(null, e)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(null, error.toException())
            }
        })
    }

    fun getChildList(userId : String, childPath: String, callback: (List<T>?, Exception?) -> Unit) {
        val ref = userReference.child(userId).child(childPath)
        fetchFromFirebase(ref, ::parseListValue, callback)
    }

    private fun <R> fetchFromFirebase(reference: DatabaseReference, parseFunction: (DataSnapshot) -> R, callback: (R? , Exception?) -> Unit) {
        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val result = parseFunction(snapshot)
                    callback(result, null)
                } catch (e : Exception) {
                    callback(null, e)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(null, error.toException())
            }
        })
    }

    private fun parseSingleValue(dataSnapshot: DataSnapshot): T? {
        println("parSingleValue = ${dataSnapshot.getValue(clazz)}")
        return dataSnapshot.getValue(clazz)
    }

    private fun parseListValue(dataSnapshot: DataSnapshot) : List<T> {
        require(dataSnapshot.exists()) {  error("No data found for $clazz") }
        dataSnapshot.getValue(clazz)
        println("parListValue = ${dataSnapshot.getValue(clazz)}")
        val items = mutableListOf<T>()
        for (child in dataSnapshot.children) {
            val item = child.getValue(clazz)
            if (item != null) {
                items.add(item)
            }
        }
        return items
    }

    private fun saveWithValueEventListener(reference: DatabaseReference, data: T, callback: (Boolean, Exception?) -> Unit) {
        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                reference.setValue(data) { error, _ ->
                    if (error == null) {
                        callback(true, null)
                    } else {
                        callback(false, error.toException())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, error.toException())
            }
        })
    }
}
