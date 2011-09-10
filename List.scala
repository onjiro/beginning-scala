// List の作成方法、いずれも同じ
1 :: 2 :: 3 :: Nil
new ::(1, new ::(2, new ::(3, Nil)))
List(1,2,3)

// 型推論を明示しない場合
// ※書籍では AnyVal 型だが Double 型に推論される・・>
List(1, 44.5, 8d)
// 型を指定した場合
List[Number](1, 44.5, 8d)

// List の先頭に要素を追加
val x = List(1,2,3)
99 :: x

// 2つのリストのマージ
val x = List(1, 2, 3)
val y = List(99, 98, 97)
x ::: y

// 関数を使う

// 奇数パスフィルター
List(1, 2, 3).filter(x => x % 2 == 1)
List(1, 2, 3).remove(x => x % 2 == 1)

// 関数を事前に定義するパターン
def isOdd(x: Int) = x % 2 == 1
List(1,2,3,4,5).filter(isOdd)

// 別の型のコレクション
"99 Red Balloons".toList.filter(Character.isDigit)

// List から特定の要素を抽出するメソッド takeWhile
// 特定の要素が false を返すまでの内容をコレクションとして返す
// ※書籍では ArrayBuffer だが、String で返される。
"Elwood eats mice".takeWhile(c => c != ' ')

// 変換

// すべて小文字にする
List("A", "Cat").map(s => s.toLowerCase)
List("A", "Cat").map(_.toLowerCase)

// 文字列長の計算
List("A", "Cat").map(_.length)

// 姓のみを返す
trait Person {def first: String}
var d = new Person {def first = "David"}
var e = new Person {def first = "Elwood"}
var a = new Person {def first = "Archer"}
List(a, d, e).map(_.first)

// HTML のリストタグを追加もできる
List(a, d, e).map(n => <li>{n.first}</li>)

// sort
List(99, 2, 1, 45).sort(_ < _)
List("b", "a", "elwood", "archer").sort(_ < _)

// 文字列の長い順
List("b", "a", "elwood", "archer").sort(_.length > _.length)

// まとめ
trait Person {
  def age: Int
  def first: String
  def valid: Boolean
}

def validByAge(in: List[Person]) = 
  in.filter(_.valid).
  sort(_.age < _.age).
  map(_.first)

// レデュシオ！

// 最大値を返す
List(8, 6, 22, 2).reduceLeft(_ max _)
// 一番長い単語を返す
List("moose", "cow", "A", "Cat").
  reduceLeft((a, b) => if (a.length > b.length) a else b)

// foldLeft は初期値をとる
List(1,2,3,4).foldLeft(0) (_ + _)
List(1,2,3,4).foldLeft(1) (_ * _)

// 戻り値は初期値の型
List("b", "a", "elwood", "archer").foldLeft(0) (_ + _.length)

// 一度に複数のコレクションを扱う
val n = (1 to 3).toList
n.map(i =>  n.map(j => i * j))

// ネストしないリストとして
n.flatMap(i =>  n.map(j => i * j))

// 見てみて！ループがないよ！

// n 中の偶数、n 中の奇数をそれぞれ掛け合わせた結果のリストを返す
// 面倒な書き方
def isOdd(in: Int) = in % 2 == 1
def isEvan(in: Int) = !isOdd(in)
val n = (1 to 10).toList
n.filter(isEven).flatMap(i => n.filter(isOdd).map(j => i * j))

// 簡潔に記載する
// for文は内部的には map, flatMap, filter に展開される
for {i <- n if isEven(i); j <- n if isOdd(j)} yield i * j

// ローマ数字表記を数値に変換する関数
def roman(in: List[Char]): Int = in match {
  case 'I' :: 'V' :: rest => 4 + roman(rest)
  case 'I' :: 'X' :: rest => 9 + roman(rest)
  case 'I' :: rest => 1 + roman(rest)
  case 'V' :: rest => 5 + roman(rest)
  case 'X' :: 'L' :: rest => 40 + roman(rest)
  case 'X' :: 'C' :: rest => 90 + roman(rest)
  case 'X' :: rest => 10 + roman(rest)
  case 'L' :: rest => 50 + roman(rest)
  case 'C' :: 'D' :: rest => 400 + roman(rest)
  case 'C' :: 'M' :: rest => 900 + roman(rest)
  case 'C' :: rest => 100 + roman(rest)
  case 'D' :: rest => 500 + roman(rest)
  case 'M' :: rest => 1000 + roman(rest)
  case _ => 0
}
