package data.db.firebase

import com.google.firebase.database.*
import javax.inject.Singleton

@Singleton
class FirebaseGenericRepository<T>(private val clazz: Class<T>) {

    private val userReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("user")

    fun getAll(callback: (List<T>?, Exception?) -> Unit) {
        userReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = mutableListOf<T>()
                dataSnapshot.children.forEach { child ->
                    val item = child.getValue(clazz)
                    item?.let { items.add(it) }
                }
                callback(items, null)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                callback(null, databaseError.toException())
            }
        })
    }

    fun get(userId: String, callback: (T?, Exception?) -> Unit) {
        userReference.child(userId).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val item = dataSnapshot.getValue(clazz)
                callback(item, null)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                callback(null, databaseError.toException())
            }
        })
    }

    fun save(userId: String, data: T, callback: (Boolean, Exception?) -> Unit) {
        userReference.child(userId).setValue(data) { error, _ ->
            if (error != null) {
                callback(false, error.toException())
            } else {
                callback(true, null)
            }
        }
    }

    fun update(userId: String, data: T, callback: (Boolean, Exception?) -> Unit) {
        userReference.child(userId).setValue(data) { error, _ ->
            if (error != null) {
                callback(false, error.toException())
            } else {
                callback(true, null)
            }
        }
    }

    fun delete(userId: String, callback: (Boolean, Exception?) -> Unit) {
        userReference.child(userId).removeValue { error, _ ->
            if (error != null) {
                callback(false, error.toException())
            } else {
                callback(true, null)
            }
        }
    }

    fun saveChild(parentId: String, childPath: String, item: T, callback: (Boolean, Exception?) -> Unit) {
        userReference.child(parentId).child(childPath).setValue(item) { error, _ ->
            if (error != null) {
                callback(false, error.toException())
            } else {
                callback(true, null)
            }
        }
    }

    fun saveChildList(parentId: String, firstChildPath: String, items: List<T>, callback: (Boolean, Exception?) -> Unit) {
        userReference.child(parentId).child(firstChildPath).setValue(items) { error, _ ->
            if (error != null) {
                callback(false, error.toException())
            } else {
                callback(true, null)
            }
        }
    }

    fun getChild(userId : String, childPath: String, callback: (T?, Exception?) -> Unit) {
        userReference.child(userId).child(childPath).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                val item = data.getValue(clazz)
                callback(item, null)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                callback(null, databaseError.toException())
            }
        })
    }

    fun getChildList(userId : String, childPath: String, callback: (List<T>?, Exception?) -> Unit) {
            userReference.child(userId).child(childPath).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val items = mutableListOf<T>()
                    dataSnapshot.children.forEach { child ->
                        val item = child.getValue(clazz)
                        item?.let { items.add(it) }
                    }
                    callback(items, null)
                }

            override fun onCancelled(databaseError: DatabaseError) {
                callback(null, databaseError.toException())
            }
        })
    }
}
