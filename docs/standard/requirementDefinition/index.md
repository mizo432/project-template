要件定義(requirement definition)
=====

# 目的

+ システムのビジネス利用用途（ビジネスユースケース）を明確化する。

* 画面を設計する際にビジネス利用用途を元に行う

* 開発を優先するビジネス利用用途を選択するために業務量を明確にする

* 運用テスト時にビジネス利用用途をシナリオとして運用ができるかを確認する

# 成果物

* ビジネスユースケース一覧
* ビジネスユースケース
* 更新業務フロー(ER) あったことを記録するために行う
* ビジネス業務ルール
* データ構造要件

ユースケースは「〇〇〇が△△△△できる。」という考え方で行う。

レベル

* 社内をブラックボックスとして社外とのやり取りを明確にする。
* 部署をブラックボックスとして、部署外とのやり取りを明確にする
* システムをブラックボックスとして、システムを利用方法を明確にする

```puml
@startuml
title: レベル0ユースケース図

:システム利用者1: as systemUser1
:システム利用者2: as systemUser2
:システム利用者3: as systemUser3
:システム利用者4: as systemUser4
:メールサーバー: as mailServer

node 会社名 {
  (利用用途1)/ as UseCase1
  (利用用途2)/ as UseCase2
  (利用用途3)/ as UseCase3
  (利用用途4)/ as UseCase4
  (請求書を発行する)/ as UseCase5
}

systemUser1 -> UseCase1
systemUser2 -> UseCase2
systemUser3 -> UseCase3
systemUser4 -> UseCase4
UseCase5 -> mailServer
systemUser1 -[hidden]- systemUser2
systemUser2 -[hidden]- systemUser3
systemUser3 -[hidden]- systemUser4

UseCase1 -[hidden]- UseCase2
UseCase2 -[hidden]- UseCase3
UseCase3 -[hidden]- UseCase4
UseCase4 -[hidden]- UseCase5

@enduml
```

```puml
@startuml
title: レベル1部門別

:システム利用者1: as productOwner1
:システム利用者2: as systemUser2
:システム利用者3: as systemUser3
:システム利用者4: as systemUser4
:メールサーバー: as mailServer

node 部門1 as Part1 {
  (利用用途1)/ as UseCase1
  (利用用途2)/ as UseCase2
  (利用用途3)/ as UseCase3
  (利用用途4)/ as UseCase4
  (請求書を発行する)/ as UseCase5
}

node 部門2 as Part2 {
  (利用用途1)/ as UseCase2_1
  (利用用途2)/ as UseCase2_2
  (利用用途3)/ as UseCase2_3
  (利用用途4)/ as UseCase2_4
}
node 部門3 as Part3 {
  (利用用途1)/ as UseCase3_1
  (利用用途2)/ as UseCase3_2
  (利用用途3)/ as UseCase3_3
  (利用用途4)/ as UseCase4_4
}

systemUser1 -> UseCase1
systemUser2 -> UseCase2
systemUser3 -> UseCase3
systemUser4 -> UseCase4
UseCase5 -> mailServer
systemUser1 -[hidden]- systemUser2
systemUser2 -[hidden]- systemUser3
systemUser3 -[hidden]- systemUser4

UseCase1 -[hidden]- UseCase2
UseCase2 -[hidden]- UseCase3
UseCase3 -[hidden]- UseCase4
UseCase4 -[hidden]- UseCase5

@enduml
```

```puml
@startmindmap
* 要件定義
** 新規開発
** 現行あり
@endmindmap
```