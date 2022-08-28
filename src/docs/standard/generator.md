ジェネレーター使用の考慮点
=====

# 業務フロー

## ステップ実行状態

```puml
@startuml
[*] --> StepExecutionState:enqueue()
  state StepExecutionState {
    [*] --> ToDo 
    ToDo --> Progress: starr()
    Progress --> Done: finish()
  }

@enduml
```

# クラス図

```puml
@startuml
title: ジョブ実行クラス図(エンティティー)
class ジョブ実行待機 <<Aggregate>> {
  ジョブ実行ID
  ジョブ定義ID
}
class ジョブ実行開始<<Aggregate>>{
  ジョブ実行ID

}
class ジョブ実行終了<<Aggregate>>{
  ジョブ実行ID

}

ジョブ実行待機 -- ジョブ実行開始
ジョブ実行待機 -- ジョブ実行終了

@enduml
```

```puml
@startuml
title: ステップ実行クラス図(エンティティー)
class ステップ実行待機 <<Aggregate>>{
  ステップ定義ID
}
class ステップ実行開始<<Aggregate>>{
  ステップ定義ID
  実行サーバー

}

class ステップ実行終了<<Aggregate>>{
  ステップ定義ID

}

ステップ実行待機 -- ステップ実行開始
ステップ実行待機 -- ステップ実行終了

@enduml
```

# モデル図

オブジェクト図でデータのイメージを作成する

```puml
@startuml
title: タイトル
object ステップ実行待機
object ステップ実行開始
object ステップ実行終了

@enduml
```

```puml
@startuml
title: ステップ実行
object ステップ実行

object ステップ実行待機

object ステップ実行開始
object ステップ実行終了
ステップ実行 -- ステップ実行待機
ステップ実行 -- ステップ実行開始
ステップ実行 -- ステップ実行終了

@enduml
```

## アーキテクチャ 解説付き

```puml
@startuml
title 概要図
together {
component [プレゼンテーション層] as Comp1
component [インフラ層] as Comp2

}
component [ユースケース層] as Comp3
component [ドメイン層] as Comp4
Comp1 -[hidden] Comp2
Comp1 --> Comp3
Comp2 --|> Comp3 
Comp4 <|-- Comp2
Comp3 --> Comp4
 
@enduml
```

```puml
@startuml
title 概要図
together {
component [プレゼンテーション層] as Comp1
component [インフラ層] as Comp2
note left of Comp1
  <b>責務:</b>
  アプリケーション外部との入出力を実現
  <b>定義するオブジェクト：</b>
  ・コントローラークラス
end note
note right of Comp2
  <b>責務:</b>
  下位レイヤーのインターフェイスを実装し
  技術的な機能を実現する
  <b>定義するオブジェクト：</b>
  ・リポジトリーの実装クラス
  ・その他下位レイヤーにあるIFの実装クラス
end note

}
component [ユースケース層] as Comp3
component [ドメイン層] as Comp4
Comp1 -[hidden] Comp2
Comp1 --> Comp3
Comp2 ..|> Comp3 
Comp4 <|.. Comp2
Comp3 --> Comp4

note left of Comp3
  <b>責務:</b>
  ユースケースの実現
  <b>定義するオブジェクト：</b>
  ・ユースケースクラス
  <color:red>・ユースケース層の処理を共通化するクラス</color>
  <color:red>・クエリーモデルとそのIF</color>
end note
note left of Comp4
  <b>責務:</b>
  ドメインモデル
  ドメイン知識(ルール/制約)の表現
  <b>定義するオブジェクト：</b>
  ・エンティティ-値オブジェクト
  ・リポジトリーインターフェイス
  ・ドメイン層の手続き的クラス
end note
 
@enduml
```

* 黒矢印は使用を示します。白矢印はインターフェイスの実装を示します。

上から下への依存はありますが、下から上への依存はないというのが特徴。
各層の責務、何を実装する層なのを抑えます。
その層にどんなオブジェクトを書くかを考えていきます。

### ドメイン層

ドメイン層にはドメインモデル図に書かれたクラスを書きます。そしてルール制約を書きます。

## aaa

```puml
@startuml
class ConcleteEntity {
    - Long identifier
    - ValueObject valueObject
    - {static} ConcleteEntityBuilder     
---
    + ValueObject valueObject()  
    + Long identifier()
    + {static} create(Long, ValueObject): ConcleteEntity
    + {static} builder() ConcleteEntityBuilder
}

@enduml
```

## 生成例

```puml
@startuml
abstract class AbstractEntity {
    - Long:identifier
    - valueObject:ValueObject   
---
    # valueObject():ValueObject;  
    # identifier():Long
      
}

class ConcleteEntity {
---
    + valueObject():ValueObject;  
}

AbstractEntity <|-- ConcleteEntity

@enduml

```

## パッケージ図

```puml
  artifact [Service] as Comp1{
     package Presentation as Comp4{
       package Api {
     
       }
       package Web {
     
       }
       package Timer {
     
       }
       package Event {
     
       }
     
     }
     package UseCase {
     }
     package QueryService {
     }
     
     Comp4 --> UseCase
     Comp4 --> QueryService
  }
  artifact [infra] as Comp2{
     package QueryService as Comp5 {
     }
     package DataSource {
     }
     package Dao {
     }
     package Remoting {
     }
     package Fao {
     }
     package mail {
     }
     package report {
     }
  }
  artifact [model] as Comp3{
    package Domain{
    }
    package Types{
    }
    
  }
     Comp1 -> Comp3
     Comp3 <|.. Comp2
QueryService <|.. Comp2

```