server-business
=====

業務ロジックを格納するモジュール

* sprint0
    * product
        * project
            * member
                * scrum master
                * product owner
                * developer
            * viewer
    * feature
        * business
* sprint
    * sprint planning
    * daily scrum
    * sprint review
    * sprint retrospective
* release planning

| レイヤーF    |   | レイヤーF   | 摘要                 |
|----------|---|---------|--------------------|
| command  | → | model   | モデル内のリポジトリーを利用する   |
| query    | → | model   | モデル内のリポジトリーを利用する   |
| scenario | → | model   | モデル内のリポジトリーを利用する   |
| scenario | → | command | コマンドを利用する          |
| scenario | → | query   | クエリーを利用する          |
| port     | → | query   | クエリーのインターフェイスを利用する |
