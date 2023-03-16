Web画面の設計
=====
パターン毎に決まっている画面遷移を修正する事により画面遷移を設計する。

モーダルによる設計/モータレスによる設計を画面遷移で意識する。

# イベント新規登録

```puml
@startsalt
{
  Just plain text
  [This is my button]
  ()  Unchecked radio
  (X) Checked radio
  []  Unchecked box
  [X] Checked box
  "Enter text here   "
  ^This is a droplist^
}
@endsalt
```

```puml
@startuml
title UC000001 ユースケース名

class 入力画面 InputView
class 一覧画面(本日入力した物) ListView

InputView -> ListView

@enduml
```