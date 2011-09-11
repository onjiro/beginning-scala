<b>Hello World</b>
<b id="greeting">Hello World</b>

// 複数行
<b id="greeting">
  <span>Hello</span> World!
  </b>

// namespace
<ns:b>Hello World from a namespace</ns:b>

// add prefix to attribute
<b ns:hi='hello'>Hello</b>

val x = <b>Hello World!</b>

// Collections
def len(seq: Seq[_]) = seq.length
len(<b>Hello</b>)
len(x)
len(List(1,2,3))

// create XML dynamic
def now = System.currentTimeMillis.toString
<b time={now}>Hello World</b>

def isOdd(in: Long) = in % 2L == 1L
import scala.xml._
def oddTime: Option[NodeSeq] = System.currentTimeMillis match {
  case t if isOdd(t) => Some(Text(t.toString))
  case _ => None
}
<b time={oddTime}>Sometimes</b>
<b time={oddTime}>Sometimes</b>
<b time={oddTime}>Sometimes</b>

// タグ、テキスト、cdata などを出力
<b>The time is {new java.util.Date}</b>
<stuff>
  {(1 to 3).map(i => <v id={i.toString}>#{i}</v>)}
  </stuff>

// if 式で else がない場合、 Unit となり、から文字へと変換されてしまう
// ・・・書籍とは動作が変わった模様。
<b>{if (true) "dogs"}</b>
// 修正
<b>{if (true) "dogs" else ""}</b>
<b>{if (false) "dogs" else ""}</b>

// 式中の文字が正しくエスケープされる
<b>{"Hello & Goodbye"}</b>
<b attr={"Hello < Zoo" }/>

// XML 中にスクリプトを埋め込む場合、エスケープしたくない。PCData を使って埋め込む
val info = """
  var x = "";
  if (true && false) alert('Woof');
  """
<script>{info}</script>
<script>{PCData(info)}</script>
