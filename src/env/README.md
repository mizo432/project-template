環境一覧

## 環境

### 開発環境

#### 全体像

```plantuml
allowmixing
title "全体環境"
actor "web利用者" as webUser
actor "clientApp利用者" as clientUser
rectangle "a" as abc  {
  node "client環境" as clientEnv{
    component "client-app" as clientApp

  } 
  node "wev環境" as wevEnv {
    component "web-app" as webApp
    database "webスキーマー" as webSchema

  } 
}
node  "api環境" as apiEnv {
  component "api-app" as api
  database "maduleスキーマー" as moduleSchema

} 

clientUser --> clientApp
clientApp --> api
webUser --> webApp
webApp --> api
webApp --> webSchema
api --> moduleSchema



```

### ステージング環境

### 本番環境

## pod
