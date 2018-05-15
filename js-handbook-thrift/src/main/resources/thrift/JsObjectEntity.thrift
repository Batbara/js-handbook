namespace java by.bsuir.talakh.jsobject

struct JsObject {
	1:i32 id
	2:string name,
	3:string description,
}

service JsObjectService{
	void addObject(1:JsObject jsObject),
   list<JsObject> takeAll(),
   void updateObject(1:JsObject jsObject),
   void deleteObject(1:JsObject jsObject),
   JsObject findById(1:i32 id),
   JsObject findByName(1:string name)
}