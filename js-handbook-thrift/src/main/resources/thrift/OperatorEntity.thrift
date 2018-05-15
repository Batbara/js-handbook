namespace java by.bsuir.talakh.operator

struct Operator {
	1:i32 id
	2:string name
	3:string operatorSymbol
	4:string description
}

service OperatorService {

   void addOperator(1:Operator operator)
   list<Operator> takeAll()
   void updateOperator(1:Operator operator)
   void deleteOperator(1:Operator operator)
   Operator findById(1:i32 id)
   Operator findByName(1:string name)

}

