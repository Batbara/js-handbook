namespace java by.bsuir.talakh.method

struct Method {
	1:i32 id
	2:string name,
	3:string description,
	4:string objectName,
	5:i32 objectId
}

service MethodService {

   void addMethod(1:Method method),
   list<Method> takeAll(1:i32 objectId),
   void updateMethod(1:Method method),
   void deleteMethod(1:Method method),
   Method findById(1:i32 id),
   Method findByName(1:string name)

}
