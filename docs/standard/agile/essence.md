アジャイルの本質
=====

# アジャイルソフトウェア開発とは？

# アジャイル開発の本質

> 予測的ではなく、適応的である
(adaptive rather than predictive)

> プロセス指向ではなく、人指向である
(people-oriented rather than process-oriented)

# アジャイルの本質①「予測的ではなく、適応的」

ソフトウェアの開発の「成功」とは何でしょうか？例として、2つのプロジェクトを考えてみましょう。

#### プロジェクトA

> 6ヶ月の計画をしたプロジェクトが、途中幾多の困難を乗り越えながら計画通りにリリースできました！ (これは「6ヶ月かかる」という見積=予測に基づくもの)

> いやーがんばった、打ち上げだ！

> しかし、そのソフトウェアは全く使われなかった…

#### プロジェクトB

> 6ヶ月の計画をしたプロジェクトでしたが、荒れに荒れてリリースまで倍の1年かかってしまいました。 その上計画していた機能の一部はリリースできませんでした。

> しかし、そのソフトウェアは多くのユーザーに愛され、ビジネス的にも大きな価値をもたらしてくれました。

さて、2つのプロジェクトはどちらが「成功」でしょうか？

アジャイルでは、プロジェクトBを成功と考えます。

アジャイル開発における成功とは、
「予測に基づいた計画を、その通りに遂行できること」ではなく、
「ソフトウェアから価値を生み出すこと」と定義されます。

## アジャイルにおける計画

アジャイルにおける計画についても述べていきます。

アジャイルにおける計画は、変更を制御するために使用するベースラインです。

従来通りに慎重に計画しますが、 プロジェクト中に学んだことを反映するために計画は絶えず改訂されます。

# アジャイルの本質②「プロセス思考ではなく、人指向」

従来型の重量プロセス指向の開発では、 とにかく属人性を排除して、機械工場のように、 誰がやっても同じようなアウトプットが安定して出ることを目指しました。

しかし、それでは不確実な環境で価値を生み出すのは難しいと言うことが、多くのプロジェクトからわかってきたのです。

そこで、アジャイルでは、
ソフトウェア開発の成功において最も重要な要素は人であり、 以下のような人間的側面こそが成功のために必要だとしています。

* スキル
* 人間性
* チームメンバー同士の連携
* 心理的安全性
* 内発的動機付け

## アジャイル開発におけるプロセス

アジャイルにおいてもプロセスは定めますが、 それは人を活かすためのものであり、機械的に従わせるために定めるものではありません。
そして、働く人がより良いプロセスを考え、独自に改善していきます。

# 「アジャイルの本質」とアジャイルマニフェストの対応

2022-06-27
アジャイル迷子のための「アジャイルの本質」。あとDDDとのつながり
記事の構成
アジャイルソフトウェア開発とは
アジャイルマニフェストとは
アジャイルマニフェストの問題
そこで、アジャイルの本質 by マーティンファウラー
アジャイルソフトウェア開発とは？
アジャイルソフトウェア開発とはなんでしょうか？

「アジャイルマニフェスト(後述)の4つの価値観、12の原則に従う開発方法の総称」

これが最もオリジナルな定義です。
なぜこんなややこしい言い回しをするのは後から説明します。

重要なことは、「アジャイル」という具体的な手法があるわけではないということです。

アジャイルはマインドセット(思想、考え方)です。そのため、

✖️ do agile 「アジャイルをやる」はありません。
⭕️ be agile 「アジャイルになる、アジャイルの思想に則る」はあります。

アジャイルの思想に則った開発手法として

・スクラム
・エクストリームプログラミング(XP)
・リーンスタートアップ
・ドメイン駆動設計

といったものがあります。

オリジナルの定義は前述の通りですが、より踏み込んだ表現になると流派、人によって重視するポイントが異なってきますが、 これはとても自然なことです。
自分がしっくりくるもの、課題感に合うものを見極めていきましょう。

そしてこの記事の内容は、割とエクストリームプログラミング寄りの話になります。
これは筆者の好み、思想の問題です。

この後の流れとしては
・アジャイルマニフェスト
・踏み込んだ定義として、マーティンファウラーが「アジャイル開発の本質」と言っている内容
について紹介していきます。

アジャイルマニフェストとは
アジャイルマニフェスト(アジャイルソフトウェア開発宣言)とは、2001年に新しいソフトウェア開発手法を構築している人たちが集まり、
その共通点を探して同意した事柄についてまとめたものです。 (XP、スクラムといった手法ははすでに形作られていました)

ここで採択された言葉が「アジャイル」です。
各自の共通の概念として「アジャイル」という言葉が定義されました。

最終的にアジャイルマニフェストとして4つの価値観、12の原則が定義されました。

アジャイルマニフェストはこちらから見られます。

次の文章は、アジャイルマニフェストの「4つの価値観」です。

私たちは、ソフトウェア開発の実践あるいは実践を手助けをする活動を通じて、よりよい開発方法を見つけだそうとしている。
この活動を通して、私たちは次のことを大切にするという結論に至った。

プロセスやツールよりも個人と対話
包括的なドキュメントよりも動くソフトウェア
契約交渉よりも顧客との協働
計画に従うことよりも変化への対応

すなわち、左記のことがらに価値があることを認めながらも、
私たちは右記のことがらにより価値をおく。

アジャイルマニフェストを読み解こう
ざっとみただけだと「ふむふむ」という感じなのですが、 これはアジャイル開発の目的を踏まえた方が読み解きやすいです。

アジャイルの目的
アジャイルの目的は、「不確実で混乱した環境に対処し、最終的に成功すること」です。

これはアジャイルアライアンス*1の定義です。

マニフェストの価値観のあとにこう付け加えてみましょう

プロセスやツールよりも個人と対話を重要視した方が、
不確実な状況下で価値を生み出しやすい

計画に従うことよりも変化への対応を重要視した方が、
不確実な状況下で価値を生み出しやすい
(あと2つは略)

こうかくと「確かにそうだよね」と受け取りやすいのではないでしょうか。

そして、4つの価値観の後に12の原則があり、より具体的な話が書いてあります。 とてもいいことが書いてあるのですが、ちょっと長くなるので一度飛ばして後から少し戻ってきます。

アジャイルマニフェストの問題
さて、以上がオリジナルな定義になるのですが、若干分かりづらい面もあります。 その結果、価値観や原則が誤解されてしまうことがよくありました。

誤解の例

「計画に従うことよりも変化への対応だから、 アジャイルだと計画は作らないんでしょ？」

これは明確にNOなのです。

アジャイルの目的に基づくと、「不確実な状況で成功する」ために必要ならば作るべきなのですが、 この例では「計画に従うことよりも」が誤って拡大解釈されてしまっています。

また、原則は非常にいいことが書かれているのですが、12個は若干多いです。

「人間が瞬間的に保持できる情報の数は「7±2」である(ミラーの法則)」とも言われていますが、その数を超えてしまっています。

そこで、マーティンファウラーによる記述を参考にしてみましょう。

アジャイルの本質 by マーティンファウラー
マーティンファウラーとは
アジャイルマニフェスト作成者の一人。
エクストリームプログラミングを初期から推進しています。
有名な書籍「リファクタリング」の著者でもあります。

彼のサイト内の記事「アジャイルソフトウェアガイド」(2019年)に このような記述があります(意訳)。

「アジャイルマニフェストから20年間近く経ったが、 当初の意図とは違う亜種がたくさん出てきた。

そこでアジャイル思考の本質的な要素を再検討した結果、 2つの要素にまとめられるという結論に至った」

そしてこのように続きます。

アジャイル開発は、

予測的ではなく、適応的である
(adaptive rather than predictive)
プロセス指向ではなく、人指向である
(people-oriented rather than process-oriented)

この2つについて読み解いていきましょう。

アジャイルの本質①「予測的ではなく、適応的」
ソフトウェアの開発の「成功」とは何でしょうか？例として、2つのプロジェクトを考えてみましょう。

プロジェクトA

6ヶ月の計画をしたプロジェクトが、途中幾多の困難を乗り越えながら計画通りにリリースできました！ (これは「6ヶ月かかる」という見積=予測に基づくもの)

いやーがんばった、打ち上げだ！

しかし、そのソフトウェアは全く使われなかった…

プロジェクトB

6ヶ月の計画をしたプロジェクトでしたが、荒れに荒れてリリースまで倍の1年かかってしまいました。 その上計画していた機能の一部はリリースできませんでした。

しかし、そのソフトウェアは多くのユーザーに愛され、ビジネス的にも大きな価値をもたらしてくれました。

さて、2つのプロジェクトはどちらが「成功」でしょうか？

アジャイルでは、プロジェクトBを成功と考えます。

アジャイル開発における成功とは、
「予測に基づいた計画を、その通りに遂行できること」ではなく、
「ソフトウェアから価値を生み出すこと」と定義されます。

アジャイルにおける計画
アジャイルにおける計画についても、先ほどの記事に記述があります。

アジャイルにおける計画は、変更を制御するために使用するベースラインです。
従来通りに慎重に計画しますが、 プロジェクト中に学んだことを反映するために計画は絶えず改訂されます。

アジャイルの本質②「プロセス思考ではなく、人指向」
従来型の重量プロセス指向の開発では、 とにかく属人性を排除して、機械工場のように、 誰がやっても同じようなアウトプットが安定して出ることを目指しました。

しかし、それでは不確実な環境で価値を生み出すのは難しいと言うことが、多くのプロジェクトからわかってきたのです。

そこで、アジャイルでは、
ソフトウェア開発の成功において最も重要な要素は人であり、 以下のような人間的側面こそが成功のために必要だとしています。

・ スキル
・ 人間性
・ チームメンバー同士の連携
・ 心理的安全性
・ 内発的動機付け

アジャイル開発におけるプロセス
アジャイルにおいてもプロセスは定めますが、 それは人を活かすためのものであり、機械的に従わせるために定めるものではありません。
そして、働く人がより良いプロセスを考え、独自に改善していきます。

「アジャイルの本質」とアジャイルマニフェストの対応
改めて、アジャイルの本質の2つの要素と、アジャイルマニフェストの価値、原則の対応を見てみましょう

## ①「予測的ではなく、適応的」との対応

### 対応している価値観

* 包括的なドキュメントよりも動くソフトウェア
* 計画に従うことよりも変化への対応

### 対応している原則(一部抜粋)

* 顧客満足を最優先し、価値のあるソフトウェアを早く継続的に提供します。
* 要求の変更はたとえ開発の後期であっても歓迎します。
* チームがもっと効率を高められるかを定期的に振り返り、それに基づいて自分たちのやり方を最適に調整します。

## ②「プロセス思考ではなく、人指向」との対応

### 対応している価値観

* プロセスやツールよりも個人と対話
* 契約交渉よりも顧客との協調

### 対応している原則(一部抜粋)

* ビジネス側の人と開発者は、プロジェクトを通して日々一緒に働かなければなりません。
* 意欲に満ちた人々を集めてプロジェクトを構成します。
* 環境と支援を与え仕事が無事終わるまで彼らを信頼します。

このように「本質」のシンプルな2つの要素から分類してみると、アジャイルマニフェスト価値観、原則がより理解しやすくなります。