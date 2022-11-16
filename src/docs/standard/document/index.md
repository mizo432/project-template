ドキュメント体系
=====
ドキュメントの体系を作成する

# システム関連図

小規模のシステム開発の場合は、レベル1でレベル2の内容を記述してレベル2は作成しない。

* レベル0 システム化対象の会社と外部ステークホルダーの関係を示す。
* レベル1 外部ステークホルダーと内部ステークホルダーとシステム化対象の会社内のシステムの関連を示す。
* レベル2 ステークホルダーと個別のシステムの関連を示す。

ドキュメントの項番はレベル0(0), レベル2(1,2), レベル3(1.1, 1.2, 2.1)

```puml
@startuml
title:0システム関連図

actor AC1 as "AC1
B社"
actor AC2 as "AC2
社外メールシステム"

node A社 {
usecase UC1 as "1
--
Aシステム"

usecase UC2 as "2
--
Bシステム"
UC1 -[hidden]- UC2 

}

AC1 -right-> UC1
UC2 -right-> AC2

@enduml
```

```puml
@startuml
title:1.Aシステム関連図

actor AC0_1 as "AC0.1
B社"
actor AC0_2 as "AC0.2
社外メールシステム"

node A社 {
actor AC1_1 as "AC1.1 経理"
node Aシステム {

usecase UC1_1 as "1.1
--
B社データ取り込みサブシステム"

usecase UC1_2 as "1.2
--
Bシステム"
UC1_1 -[hidden]- UC1_2 

}
AC1_1 -right-> UC1_1

}

AC0_1 -right-> UC1_1
UC1_2 -right-> AC0_2

@enduml
```

```puml
@startuml
title:1.1 システム関連図

actor AC0_1 as "AC0.1
B社"

actor AC1_1 as "AC1.1 経理"

node node_1_1 as "1.1 B社データ取り込みサブシステム" {

usecase UC1_1_1 as "1.1.1
--
B機能G"
usecase UC1_1_2 as "1.1.2
--
C機能G"

UC1_1_1 -[hidden]- UC1_1_2 

}
AC1_1 -right-> UC1_1_2

AC0_1 -right-> UC1_1_1

@enduml
```
