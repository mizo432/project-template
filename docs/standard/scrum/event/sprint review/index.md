スプリントレビューの進め方
=====
スクラムにおいてはフィードバックが重要です。プロセスに対するフィードバックはスプリントレトロスペクティブ、プロダクトに対するフィードバックはスプリントレビューを活用します。

今日はスプリントレビューについて、一般的な手順や注意点を紹介します。

# スプリントレビューの目的

まず最初にスプリントレビューの目的を再確認しておきましょう。スクラムガイドの最新版では、スプリントレビューを以下のように定義しています。

> >
スプリントレビューとは、スプリントの終了時にインクリメントの検査と、必要であればプロダクトバックログの適応を行うものである。スプリントレビューでは、スクラムチームとステークホルダーがスプリントの成果をレビューする。スプリントの成果とプロダクトバックログの変更を参考にして、価値を最適化するために次に何ができるかを参加者全員で話し合う。これはステータスミーティングではなく、略式のミーティングである。インクリメントを提示することで、フィードバックや協力を引き出すことを目的とする。

ちょっと分かりにくいので順番を入れ替えて説明しておきましょう。

* スプリントレビューの目的は、インクリメントを提示することで、フィードバックや協力を引き出すことです。その背後にあるのはプロダクトの価値の最適化です。
* フィードバックを踏まえて、プロダクトバックログアイテムを追加したり削除したり順番を入れ替えたりして、限られた時間や予算の中で価値を最大にできるように向かう先を修正していきます。

```
すなわち、スプリントレビューは単なる進捗報告会ではありません。
```

# スプリントレビューの参加者

スプリントレビューの参加者は、スクラムチームと、そのプロダクトに関わるステークホルダーです。

__ここで重要なのはステークホルダーです。__ ステークホルダー不在で、スクラムチームだけでスプリントレビューを行っても不十分です。

例えば、ステークホルダーには、企画、マーケティング、営業、サポート、QA、実際の利用者、連携先システムの担当者、自分の部門のマネジメントの人などが含まれます。
いつも関係者全員を呼ぶのではなく、その時のスプリントゴールやプロダクト全体の進捗にあわせて、必要な時に必要な人を呼べば良いでしょう。ベロシティの低いチームが、忙しいステークホルダーを毎週呼んでデモを見せようとしたら、途中から来なくなってしまいます。

なお、これらのステークホルダーがスプリントレビューにどうしても来られない場合は、プロダクトオーナーは直接時間を取って訪問しフィードバックを貰っても構いませんし、そうすべきです。

## 1. __チェックイン、目的の共有__

まず、簡単にスプリントレビューの目的やタイムボックスやワーキングアグリーメントを説明します
開発チームにとってはステークホルダーとの数少ない接点なので、そのステークホルダーが初参加なのであれば名前や役割などを自己紹介しておきます。

## 2. __前提事項の共有__

このスプリントレビューでの前提事項も共有しておきます。例えば、画面デザインに関しては別途入れ替えるのでデザインに関するフィードバックは不要、などと共有しておくと、参加者も集中しやすくなります。

## 3. __これからデモする内容についての概要を説明__

今回のスプリントのスプリントゴールがどのようなもので、なぜそのゴールになっているのか、どのように重要なのか、誰にとって役に立つのかなどを説明します。
スプリントゴールを踏まえて、今回のスプリントで選択したプロダクトバックログアイテムを共有し、完成しているものは何か、完成していないものは何かを明らかにします。

## 4. __今スプリントで完成したもののデモとフィードバック、Q&A__

デモをするのは完成したプロダクトバックログアイテムです。
デモを誰がやるのかについて特に決まりはありませんが、プロダクトオーナーは参加者のフィードバックを書き留めたり、議論に参加する必要があるので、開発者にやってもらった方が進めやすいでしょう。
デモの説明や操作は作り手の視点よりも実際のユーザーの視点である方が好ましいと言えます。ステークホルダーもその視点で見るからです。
ステークホルダーによってはコンテキストが分からないこともあるので適宜補足しながら進めます。

## 5. __スプリント中の状況の変化などの共有と議論__

スプリント中に分かった大きな課題や状況の変化を共有します。ステークホルダーによってはそれによって大きな影響を受ける人がいるかもしれません。その場合はなんらかのフィードバックが得られるはずです

## 6. __今後の見通しや直近のスプリントでやろうとしていることの共有__

次回のスプリントの予定、特定のマイルストンに向けた着地の見通しなどを共有します。

## 7. __まとめ__

# スプリントレビューの事前準備

スプリントレビューのアジェンダの例を見ると、事前準備が必要であることが分かるはずです。
スプリントレビュー自体はフォーマルな会議ではないので、過度に準備しすぎてはいけませんが、準備をしなさすぎると、折角集まってくれたステークホルダーの時間をムダにし、フィードバックも得られなくなってしまいます。
準備の目安はおおよそ1時間程度と考えておくと良いでしょう。

主な準備の内容は以下のようなものです。

* __プロダクトオーナーは事前にプロダクトバックログアイテムの受入判定を済ませる__
    *
  完成したプロダクトバックログアイテムがデモの対象となるので、プロダクトオーナーはあらかじめプロダクトバックログアイテムのそれぞれが完成しているのか完成していないのか判定しておく必要があります。なおスプリントレビューの前日や当日にまとめてやろうとすると多くの場合は辛いことになります。
* __スプリントレビューでのデモ手順やシナリオの確認__
    * デモ用の端末やデモ環境にプロダクトを入れて、動作するかを確認しておきます。 また、複数人で連携してデモする場合には役割分担決めておきます
* __最新のプロダクトバックログ__
    * 適宜プロダクトバックログのリファインメントをしていれば問題ないと思いますが、最新版を用意しておき、次のスプリントで検討している内容や今後の見通しなどを説明できるようにしておきます。
      プレゼンテーションなどの簡単な説明資料の準備（必要であれば）
      アジェンダ、プロダクトバックログの説明、この後の予定の共有などで資料があった方が良い場合は簡単に作っておきます。あくまで非公式な資料なので凝りすぎないようにします。
* __ステークホルダーの招集__
    *
  これが非常に重要です。プロダクトオーナーはどのステークホルダーを呼ぶか判断して事前に調整しておいてください。頻繁に来てほしいステークホルダーの場合は最初に先の予定まで確保しておいて、不要な場合はキャンセル通知をするような運用が楽です。

# ステークホルダーへの質問（例）

スプリントレビューでは、ステークホルダーからの意見やフィードバックを貰います。
何も言わなくてもたくさんのフィードバックをくれる人と、そうでない人がいますので、状況を踏まえて定形的な質問パターンを使うのも良いでしょう。例えば以下のようなものです。

* 気に入ったか？
* いちばん気に入った箇所と、いちばん気に入らなかった箇所はなにか？
* プロダクトを成功させるために変えたらよいことがあるか？
* ビジョンはまだ有効か？
* 機能不足、過剰な機能や表示項目があるか？
* 機能の間違いはないか？
* 見た目の調整が必要か？
* そう思うのはなぜか？
* 考慮が不足している機能はあるか。

# こんなスプリントレビューには気をつけよう

最後に、スプリントレビューがこのような状態だったら注意して改善しよう、というポイントをあげておきます。

* __完成していないものをデモしている__
    *
  何も完成したものがない状態でも、なんとかスプリントレビューでフィードバックを貰いたいという気持ちは分かりますが、やめておいてください。動いていないもの、中途半端なものを見せるとフィードバックの質も下がりますし、スクラムチームに対する信頼もなくなります。スプリントレビューではスクラムチームが完成させたものを自慢するくらいの感じで進めるのが理想です
* __完成したものと完成していないものをスプリントレビューで識別している__
    *
  スプリントレビューは受け入れ確認の場ではありませんし、前述のとおり動かないもの、正しくないものを多くのステークホルダーに見せる意味もありません。なおステークホルダーが受け入れ可否を決めるわけではなく、それを決めるのはプロダクトオーナーです。もしステークホルダーの承認のようなものがないと完成に至らないのだとすると、ロールの割当が適切ではない可能性があります。
* __スプリントレビューが進捗確認会議になっている__
    *
  全体の見通しの共有自体は重要であることは間違いありませんが、主目的はプロダクトの価値を高めるためにフィードバックを受けることです。もし進捗確認会議が必要なら、プロダクトオーナーとスクラムマスターあたりが別の会議を設けると良いと思います。
* __プロダクトオーナーがステークホルダーを招集していない__
    *
  たくさんの時間とお金を使ったあとに、それがムダになるようなフィードバックを貰いたくないはずです。しかるべきステークホルダーを選んで適宜呼ぶようにしてください。もしスプリントレビューにステークホルダー不在の状況が続くのであれば、スクラムマスターは手を打つべきです。
* __最新の情報を使って今後の見通しなどの話し合いをしていない__
    *
  ステークホルダーの一部、たとえばマーケティングや営業の人などは、そのプロダクトがいつリリースされそうかということに対して強い関心を持ちますし、彼らの仕事はリリースに対する依存関係があります。見通しを共有しないとビジネス全体から見た最適化ができなくなってしまうので、短時間で良いので今後の見通しを話すようにします。