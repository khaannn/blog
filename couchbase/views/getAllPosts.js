{
    "id": "firstView"
    "_id":"_design/posts",
    "_rev":"12345",
    "language":"javascript",
    "views":
    {"findAll":
        {"map":"function(doc) {if (doc._class == 'com.khaannn.couchbase.repository.Post') {emit(null, null);}"}
    }
}
