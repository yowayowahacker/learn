# ユーザエラー自己解決プログラム（Errsettle.java)
　Linuxコマンドの実行時にエラーが発生した場合、エラーの原因を解析し、エラーを解決するための処理を実行します。
 
 このプログラムは、`mkdir`　と　`rmdir`　の実行時に発生したエラーだけを解決することができます。
 
 → https://github.com/yowayowahacker/learn/blob/master/Errsettle.java


# パスワード自動生成（autopass.py)
　乱数を発生させ、Asciiコードをから文字に変換、8回繰り返して8文字のパスワードを作成する。
 作成したパスワードに用途とアカウント名を与えて、ファイルに保存する。

欠けている機能
- パスワードを保存するときに暗号化をせずに保存している。
- 保存しているパスワードと被る可能性がある。

 → https://github.com/yowayowahacker/learn/blob/master/autopass.py
 ## (Makepass.java)
 Java版です
 → https://github.com/yowayowahacker/learn/blob/master/Makepass.java

# Rot13（Rot13.py）
　Rot13をPythonで書いたものです。
 入力された文字列を文字ごとにAsciiコードに直して、コード + 13　をして、文字に戻す処理をしています。
 +13をしたときにA~Zに収まらないものは-26をしてうまく回転するようにしています。

→ https://github.com/yowayowahacker/learn/blob/master/rot13.py

# Javaのデバックツールを作る
　ものすごく途中で未完成品ですが、これは、難しいデバックツールが使えないため　⇒　System.out.println("A");を入れる
 
 これを手作業でやるととても面倒なので自動化しようというものです。
 
 進捗としては、編集するファイルを読み込んだところです。
 
 このあとやらないといけないのは、
 readlinkを使ったPATH取得の自動化,
 文字列の置き換え処理,
 （例外処理を書くこと）

勉強会で、linuxコマンドのmakeとsedを駆使すればなんとかなるのでは、、、という話
