for {i <- 1 to 3} println(i)

for {i <- 1 to 3
     j <- 1 to 3} println(i * j)

def isOdd(in: Int) = in % 2 == 1
for {i <- 1 to 5 if isOdd(i)} println(i)

for {i <- 1 to 5
     j <- 1 to 5 if isOdd(i * j)} println(i * j)

// ひとつ以上のコレクションから新しいコレクションを作成
val lst = (1 to 18 by 3).toList
for {i <- lst if isOdd(i)} yield i

// ネスト、パターンガード付きyield
for (i <- lst; j <- lst if isOdd(i * j)) yield i * j

