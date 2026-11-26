# Javaについて学んだこと

## inputField.setOnAction(_ ->{
})
inputFieldに文字を入力してEnterキーを押すと実行される処理を登録できる。


## selected == null || selected.isBlank()
 は、ComboBox から取得した値が未選択または空文字・空白のみ（"" や "   "）の場合に、後続の出力処理をスキップするためのガード条件

## ガード条件
本処理を実行する前に「想定外の値や進められない状態」を早期に弾いて処理を中断するための条件式