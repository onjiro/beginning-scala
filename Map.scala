// Mapの作成方法, Pair インスタンスを渡す
var p = Map(1 -> "David", 9 -> "Elwood")
// Pair を優先する事を明示しないと + が先に評価されてしまいエラーとなる。
// p + 8 -> "Archer"
p + (8 -> "Archer")

// Map はイミュータブルなので、p の内容は変更されていない
p
//p = p + 8 -> "Archer"
p = p + (8 -> "Archer")
p += 8 -> "Archer"
p

// 要素取得
p(9)

// 存在しない要素の取得はエラーとなる
p(88)

// Map#get は Option を返す
p.get(88)
p.get(9)

// Map#getOrElse で値が存在しない場合にデフォルト値を返す
p.getOrElse(99, "Nobody")
p.getOrElse(1, "Nobody")

// Map#flatMap でも Option を使用可能
// 結果は書籍と変わっている
1 to 5 flatMap(p.get)

// 要素の削除
p -= 9
p

// キーが含まれるか確認
p.contains(1)
p.keys.reduceLeft(_ max _)

// 最も大きい String を取得
p.values.reduceLeft((a, b) => if (a > b) a else b)

// z が含まれているか
p.values.exists(_.contains("z"))

// ++ による追加と -- による削除
p ++= List(5 -> "Cat", 6 -> "Dog")
p --= List(8, 6)

// Map#filter
trait Person {
  def age: Int
  def first: String
  def valid: Boolean
}
def removeInvalid(in: Map[Int, Person]) = in.filter(kv => kv._2.valid)

