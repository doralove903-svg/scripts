# scripts

日々のちょっとした作業を楽にするための個人用スクリプト置き場。

## 中身

| スクリプト | 説明 |
| --- | --- |
| `powershell/Get-FolderSize.ps1` | 指定フォルダ直下の各項目のサイズを大きい順に表示する |
| `java/IsFloat/Main.java` | 文字列が浮動小数点数かを状態遷移で判定する練習問題（`isFloat` は未実装） |

## 使い方

```powershell
./powershell/Get-FolderSize.ps1 -Path C:\Users\doral\Downloads
```

## 開発フロー

`main` はブランチ保護しているので直接 push できない。作業ブランチ + PR で進める。

```powershell
cd C:\scripts
git switch -c feature/なにか
# ...編集...
git add -A
git commit -m "説明"
git push -u origin feature/なにか
```

その後 GitHub で PR を作成し、diff を自分で確認して「Merge」する（承認は不要）。

## メモ

遊びで作ったリポジトリ。気が向いたらスクリプトを足していく。
