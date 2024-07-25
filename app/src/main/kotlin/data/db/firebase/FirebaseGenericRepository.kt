package data.db.firebase

import com.google.firebase.database.*
import javax.inject.Singleton

@Singleton
class FirebaseGenericRepository<T>(private val clazz: Class<T>) {

    private val userReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("User")

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

    fun saveChildOfChild(parentId: String, firstChildPath: String, secondChildId: String, item: T, callback: (Boolean, Exception?) -> Unit) {
        val ref = userReference.child(parentId).child(firstChildPath).child(secondChildId)
        saveWithValueEventListener(ref, item, callback)
    }

    fun getChild(userId : String, childPath: String, callback: (T?, Exception?) -> Unit) {
        val ref = userReference.child(userId).child(childPath)
        fetchFromFirebase(ref, ::parseSingleValue, callback)
    }

    fun getChildOfChild(userId : String, childPath: String, secondChildPath: String, callback: (T?, Exception?) -> Unit) {
        val ref = userReference.child(userId).child(childPath).child(secondChildPath)
        fetchFromFirebase(ref, ::parseSingleValue, callback)
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

    private fun parseSingleValue(dataSnapshot: DataSnapshot): T? = dataSnapshot.getValue(clazz)

    private fun parseListValue(dataSnapshot: DataSnapshot) : List<T> {
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
