# セットアップ手順（そのまま実行できる版）

## 1) GitHubにテスト用リポジトリを作る
- GitHub → New repository
- 例: `copilot-github-lab`
- **Public推奨**（まず詰まらない）
- READMEは無くてもOK（このZIPに含まれているため）

## 2) このZIPの中身を push
### Windows（Git Bash想定）
```bash
cd <展開先フォルダ>
git init
git add .
git commit -m "initial lab project"
git branch -M main
git remote add origin <あなたのGitHubリポジトリURL>
git push -u origin main
```

## 3) Issueを作る（例）
- GitHub → Issues → New issue → Bug report
- 例:
  - 何が起きた？: 「タスク追加でクラッシュする」
  - 再現手順: 「1. 起動 2. タイトル未入力で追加 3. クラッシュ」
- 作成したら `Issue #1` の番号を覚える

## 4) Android Studioで Clone
- File → New → Project from Version Control
- URLを貼り付けてClone
- 右下でGradle同期が走る（少し待つ）

## 5) Copilot Chat で @github を試す
例:
- `@github issue #1 を要約して`
- `@github issue #1 を踏まえて修正方針を提案して`

## 6) PRも試す（おすすめ）
### ブランチ作成
```bash
git checkout -b fix/validate-title
```

### 例: 修正案（あなたが実装してOK）
- `TaskRepository#saveTask` で title null/空白を弾く
- 既存呼び出し元（TaskService/Controller）への影響も整える

### push → PR作成
```bash
git add .
git commit -m "Validate title in saveTask"
git push -u origin fix/validate-title
```

- GitHub上で "Compare & pull request" を押してPR作成

## 7) PRに対して @github
- `@github pull request #1 の変更点を要約して`
- `@github pull request #1 をレビューして（null安全性/影響範囲/例外設計）`

## うまく動かない時のチェック
- Android Studio で GitHub にサインイン済み？
- Copilot のサインイン/サブスクは有効？
- private repo の場合、組織SSO/権限はOK？
- 会社プロキシ環境だとGitHub APIがブロックされることがあります
