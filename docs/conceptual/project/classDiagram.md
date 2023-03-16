Project class diagram
=====

# サンプル

```puml
@startuml Book Store sample

'!include https://raw.githubusercontent.com/gnodux/coloruml/master/coloruml.puml

!include ./colorUml.puml
'left_to_right()
legend()
thing(プロジェクト,Project){

}

role(現在プロジェクト, CurrentProject){
}

Project -> CurrentProject

moment(注文, Order){
    int OrderId
    int Status

}
role(ThingRole)
role(PersonRole)
role(PlaceRole)
moment(Bill)
moment(Delivery)
interval(見積もり, estimate)
detail(見積もり明細)
thing(Book)
desc(Comments)
desc(ThingDescription)
desc(PlaceDescription)
desc(PersonDescription)

role(Customer)
thing(Employee){
    String Name
    Date Birthday
    int Status()
}
thing(Author)
role(Courier)
role(Accounting)

Courier from(Employee)
Accounting from(Employee)

Book contains(Comments)
Book has_d(Author)
Order contains(Bill)
Order contains(Delivery)
Order has(Book)
Bill has(Accounting)
Delivery has(Courier)
Customer has(Order)
Customer has(Comments)

Bill layout_u(Delivery)

@enduml
```