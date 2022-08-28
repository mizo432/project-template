Conventional Commits 1.0.0
###
# 概要
Conventional Commits の仕様はコミットメッセージのための軽量の規約です。 明示的なコミット履歴を作成するための簡単なルールを提供します。この規則に従うことで自動化ツールの導入を簡単にします。 コミットメッセージで機能追加・修正・破壊的変更などを説明することで、この規約は SemVer と協調動作します。

コミットメッセージは次のような形にする必要があります:

原文：
```
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]
```
訳：
```
<型>[任意 スコープ]: <タイトル>

[任意 本文]

[任意 フッター]
```
あなたのライブラリの利用者に意図を伝えるために、コミットは以下の構造化された要素を持ちます：

fix: 型 fix を持つコミットはコードベースのバグにパッチを当てます (これは Semantic Versioning における PATCH に相当します)。
feat: 型 feat を持つコミットはコードベースに新しい機能を追加します (これは Semantic Versioning における MINOR に相当します)。
BREAKING CHANGE: フッター に BREAKING CHANGE: が書かれているか型/スコープの直後に ! が追加されているコミットは API の破壊的変更を導入します (Semantic Versioning における MAJOR に相当します)。 BREAKING CHANGE は任意の 型 のコミットに含めることができます。
fix: や feat: 以外の 型 も許されています。たとえば @commitlint/config-conventional (これは Angular の規約 が基になっています) は build:, chore:, ci:,docs:, style:, refactor:, perf:, test:, などを推奨しています。
git trailer format に似た規約に従って、BREAKING CHANGE: <タイトル> 以外の フッター が与えられるかもしれません。
追加の型たちは Conventional Commits の仕様で義務付けられているものではなく、(BREAKING CHANGE を含まない限り) Semantic Versioning に対する暗黙的な効果を持ちません。

コミットの型には追加の文脈の情報として スコープ を追加することができます。スコープは括弧で囲みます。たとえば feat(parser): add ability to parse arrays のようになります。

# 例
## タイトルおよび破壊的変更のフッターを持つコミットメッセージ
```
feat: allow provided config object to extend other configs

BREAKING CHANGE: `extends` key in config file is now used for extending other config files
```
## 破壊的変更を目立たせるために ! を持つコミットメッセージ
```
feat!: send an email to the customer when a product is shipped
```

## スコープおよび破壊的変更を目立たせるための ! を持つコミットメッセージ
```
feat(api)!: send an email to the customer when a product is shipped
```
## ! と BREAKING CHANGE フッターの両方を持つコミットメッセージ
```
chore!: drop support for Node 6

BREAKING CHANGE: use JavaScript features not available in Node 6.
```
## 本文を持たないコミットメッセージ
```
docs: correct spelling of CHANGELOG
```
### スコープを持つコミットメッセージ
```
feat(lang): add polish language
```
### 複数段落からなる本文と複数のフッターを持ったコミットメッセージ
```
fix: prevent racing of requests

Introduce a request id and a reference to latest request. Dismiss
incoming responses other than from latest request.

Remove timeouts which were used to mitigate the racing issue but are
obsolete now.

Reviewed-by: Z
Refs: #123
```

# 仕様
この文書におけるキーワード「しなければならない (MUST)」「してはならない (MUST NOT)」「要求されている (REQUIRED)」「することになる (SHALL)」「することはない(SHALL NOT)」「する必要がある (SHOULD)」「しないほうがよい (SHOULD NOT)」「推奨される (RECOMMENDED)」「してもよい (MAY)」「選択できる (OPTIONAL)」は RFC 2119 (IPA 日本語訳) で述べられているように解釈されるべきものです。

1. コミットは feat や fix などの型から始まり (MUST)、その後ろにはスコープ (OPTIONAL) と ! (OPTIONAL) が続き、その後ろにコロンとスペース (REQUIRED) が続く。
2. コミットがあなたのアプリケーションやライブラリに新しい機能を追加するとき、型 feat が使われなければならない (MUST)。
3. コミットがあなたのアプリケーションのためのバグ修正を行うとき、型 fix が使われなければならない (MUST)。
4. スコープを型の後ろに記述してもよい (MAY)。スコープは、コードベースのセクションを記述する括弧で囲まれた名詞にしなければならない (MUST)。例: fix(parser):。
5. 型/スコープの後ろのコロンとスペースの直後にタイトルが続かなければならない (MUST)。 タイトルはコード変更の短かい要約である。例: fix: array parsing issue when multiple spaces were contained in string。
6. 短いタイトルの後ろにより長いコミットの本文を追加してもよい (MAY)。これはコード変更に関する追加の情報を提供する。 本文はタイトルの下の 1 行の空行から始めなければならない (MUST)。
7. コミットの本文は自由な形式であり、改行で区切られた複数の段落で構成することができる (MAY)。
8. ひとつ以上のフッターを、本文の下の 1 行の空行に続けて書くことができる (MAY)。 それぞれのフッターは、ひとつの単語トークン、それに続く :<space> か <space># によるセパレータ、そして文字列の値から構成されなければならない (MUST) (これは git trailer convention に触発されている)。
9. フッターのトークンは空白の代わりに - を使わなければならない (MUST)。例えば Acked-by とする (これは複数段落からなる本文からフッターを区別するのに役立つ)。 例外として BREAKING CHANGE があり、これをトークンとして使用することができる (MAY)。
10. フッターの値にはスペースと改行を含めることができる (MAY)。そして次のフッターのトークンとセパレータの組が見つかった時、以前のフッターのパースは終了しなければならない (MUST)。
11. 破壊的変更は、コミットの型/スコープの接頭辞か、フッターによって明示されなければならない (MUST)。
12. 破壊的変更がフッターとして含まれる場合は、大文字の BREAKING CHANGE の後ろにコロンとスペース、そしてタイトルを続けなければならない (MUST)。例: BREAKING CHANGE: environment variables now take precedence over config files。
13. 破壊的変更が型/スコープの接頭辞として含まれる場合は、: の直前に ! を用いて明示されねばならない (MUST)。! が使用すれた場合には、 フッターから BREAKING CHANGE: を省略してもよい (MAY)。その場合はコミットのタイトル部分で破壊的変更の内容を説明することになる (SHALL)。
14. feat と fix 以外の型を使うことができる (MAY)。例: docs: updated ref docs.。
15. Conventional Commits を構成する情報の単位は、大文字の BREAKING CHANGE を除いて、実装は大文字と小文字を区別してはならない (MUST NOT)。
16. フッターのトークンにおいて BREAKING-CHANGE は BREAKING CHANGE と同じトークンとして解釈されなければならない (MUST)。

# 何故 Conventional Commits を使うのか
変更履歴 (CHANGELOG) を自動的に生成できます。
semantic version 単位で自動的に履歴をまとめられます (コミットの型に基づきます)。
チームメイトや一般のユーザー、およびその他の利害関係者へ変更の内容を伝えることができます。
ビルドや公開の処理をトリガーできます。
より構造化されたコミット履歴を調査できるようにすることで、人々があなたのプロジェクトに貢献しやすくなります。
# よくある質問
## 初期の開発段階ではコミットメッセージをどのように扱うべきですか？
すでに製品をリリースしているかのように進めることをお勧めします。 あなたの仲間のソフトウェア開発者であっても、普通は 誰か があなたのソフトウェアを使っています。 何が修正されたのかや何が壊れたのかなどを彼らは知りたいでしょう。

## コミットタイトル (1 行目) の型は大文字か小文字のどちらがよいですか？
どちらでも問題はありませんが、一貫性を保つべきです。

## コミットが複数のコミット型からなるような場合はどうすればよいですか？
可能な限り、引き返して複数のコミットに分割します。 Conventional Commits の利点のひとつは、より組織化されたコミットとプルリクエストを行う事を可能にする事です。

## これは開発速度とインテグレーションを遅くしたりはしませんか？
無秩序にただ早く開発することはお勧めではありません。 これはあなたがさまざまな貢献者との複数のプロジェクト間で長期的に素早く動けるようにするのを助けます。

## Conventional Commits では開発者は与えられた型の中で考える必要があるため、作ることのできるコミットの種類が制限されてしまうのではありませんか？
Conventional Commits は fix などの特定の型を持つコミットを作るように促します。 それ以外には、Conventional Commits の柔軟性は、あなたのチームが独自の型を提案し作り、また時間の経過とともにそれらの型を変更していくことを許します。

これは SemVer とどのような関係を持っていますか？
fix 型のコミットは PATCH リリースへ変換されます。feat 型のコミットは MINOR リリースへ変換されます。型にかかわらずコミット内で BREAKING CHANGE を使ったコミットは MAJOR リリースに変換されるべきでしょう。

## Conventional Commits の仕様についての私の拡張はどのようにバージョンを振るべきでしょうか？ 例: @jameswomack/conventional-commit-spec
SemVer を使用して、この仕様に対する独自の拡張をリリースすることをお勧めします (そしてそのような拡張仕様の作成を推奨します！)。

## 間違ったコミット型を使用してしまった時はどうしたらいいですか？
### 仕様的に正しい型だが意味的にを間違った型を使用した場合、たとえば feat の代わりに fix
間違いをマージやリリースする前に、git rebase -i を使ってコミット履歴を編集することをお勧めします。 リリース後であれば、どのようなツールやプロセスを使用しているかによって後始末は異なってくるでしょう。

### 仕様に ない 型を使った場合、例えば feat ではなく feet
最悪のシナリオはコミットが Conventional Commits の仕様を満たさない場合です。しかしそれは世界の終わりではありません。 それは単に仕様に基づいているツールによってコミットが見逃されるだけでしかありません。

## 貢献者全員が Conventional Commits の仕様を使用する必要がありますか？
いいえ！ Git で squash ベースのワークフローを使用する場合は、主要メンテナがマージ時にコミットメッセージをクリーンアップすることができるため、臨時のコミッタには作業負荷がかかりません。 また、これをするための一般的な方法としては、プルリクエストからのコミットを git システムが自動的に squash し、主要メンテナによるマージ時に適切な git コミットメッセージを入力するためのフォームを表示するというものです。

## Conventional Commits は revert コミットをどのように扱いますか？
コードを revert するのは複雑な場合があります。 複数のコミットを revert しますか？ 機能を revert するとき、次のリリースはただのパッチでしょうか？

Conventional Commits は revert の振る舞いを定義するための明示的な努力をしません。 その代わりに、revert を処理するためのロジックを型とフッターの柔軟性を利用して開発するようなツールの作者に、これを任せます。

我々のおすすめの方法としては、ひとつは revert 型と revert されるコミットの SHA を参照するフッターを使うようにすることです。

revert: let us never again speak of the noodle incident

Refs: 676104e, a215868