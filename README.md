# project-template

## モジュール一覧

| 名称                          | 概要                                                                                                          | 依存ライブラリー                                                                                 |
|-----------------------------|-------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| common-primitive            | javaのオブジェクトに関するユーティリティーを格納するモジュール。<br/>業務的な部品ではない。                                                          | なし                                                                                       |
| common-precondition         | 事前条件をチェックするための汎用チェッカーを格納するモジュール。<br/>汎用チェッカーを利用し業務APIや業務webアプリケーションでチェックを行う。<br/>内部的にprimitiveモジュールを利用している。 | common-primitive                                                                         |
| common-message              |                                                                                                             | common-primitive                                                                         |
| common-exception            | 例外を格納するライブラリー                                                                                               | common-primitive<br/>common-message                                                      |
| web-common                  | サーバーアプリの共通ライブラリー                                                                                            | common-primitive<br/>common-message<br/>common-exception                                 
| web-security                | セキュリティー用のライブラリー                                                                                             | common-primitive<br/>common-message<br/>common-exception<br/>web-common                  | common-test                 | 単体テスト用のライブラリー                                                                                               | なし                                       |
| web-authorization           | 認可サーバー                                                                                                      | なし                                                                                       |
| web-validation              | springに定義されていないバリデーション                                                                                      | common-primitive<br/>common-message<br/>common-exception                                 |
| server-buisiness            | モデル・ビジネス層・インフラ層                                                                                             | common-primitive<br/>common-message<br/>common-exception<br/>web-common<br/>web-security |
| web-backend                 | APIアプリのサンプル,Webアプリのサンプル                                                                                     | common-primitive<br/>common-message<br/>common-exception<br/>web-common<br/>web-security |
| web-front                   | Webアプリのサンプル                                                                                                 | common-primitive<br/>common-message<br/>common-exception<br/>web-common<br/>web-security |
| web-admin                   | 管理アプリ                                                                                                       | なし                                                                                       |
| template-client-application | クライアントアプリ                                                                                                   | なし                                                                                       |

# webApi

### リソースのCRUD-API

リソースの取得、作成、変更、削除を行う。

## uriの設計指針

エンドポイントは下記の形式

```
/api/{v1.0}/{domain}/{resourceNames}/{identifier}
```

{v1.0}: バージョン
{domain}: 業務領域名 部署など 例:経理
{resourceNames}: 扱うリソース名を複数形で設定する 例:お客様 customers
{identifier}: 扱うリソース名を特定する場合に設定する 例:お客様id customers

/api/v1.0/accounting/accountTitles/aaaaaaaaaaaa

/api/v1.0/sales/reserves

この様に{identifier}が存在しない場合は全体を指す

/api/v1.0/salesDepartment/customers/aaaaaaaaaa/reserves

この様にリソースが長い場合も存在する
（営業部門で特定のお客様の予約を示すリソースなど）

api/v1.0/customer/reserves
お客様が自身の予約を取得するAPI

## apiのメソッド

GET リソースの情報の取得
POST リソースの登録
PUT リソースの変更
DELETE リソースの削除

httpStatus

| メソッド   | 正常時ステータスコード     | パラメータエラー         | 摘要          |
|--------|-----------------|------------------|-------------|
| GET    | Ok(200)         | Bad request(400) |             |
| POST   | Created(201)    |                  |             |
| PUT    | Ok(200)         |                  |             |
| PATCH  | Ok(200)         |                  | エンティティの一部更新 |
| DELETE | No content(204) |                  |             |

PUTとDELETEはリソースの{identifier}が必須
GETは必要な情報に合わせて{identifier}が必須。{identifier}つけない場合、クエリーパラメーターで検索条件を付与する

# 業務上のイベントAPI

リソースの操作
お客様が商品を買い物かごに追加する
api/v1.0/customer/product/{productId}/addToBasket

api/v1.0/customer/customer/{customerId}/addProductToBasket

api/v1.0/sales/customer/{customerId}/addProductToBasket

## アプリケーションレベルの配置図

```puml
@startuml
title アプリケーション依存図
component "web-front" as application
component "api-back" as api

application -> api

@enduml
```

# Webページの場合

## メソッド

処理時のレスポンスはOK(200)とする
| ページ種類 | メソッド |
|-------------|------|
| ①情報の一覧表示ページ | GET |
| ②情報の個別表示ページ | GET |
| ③新規登録用入力ページ | GET |
| ④新規登録処理 | POST |
| ⑤変更用入力ページ | GET |
| ⑥更用確認ページ | GET |
| ⑦変更処理 | POST |
| ⑧削除処理 | POST |

# クライアント依存外部ライブラリー

## materialize

https://github.com/materializecss/materialize

##                     
