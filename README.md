# Copilot @github Lab (Android Studio / IntelliJ)

このリポジトリは **GitHub Copilot Chat の `@github`** を試すための最小構成サンプルです。
Android Studio でもそのまま開けます（Gradleプロジェクト）。

## 目的
- Issue を作って `@github issue #...` で要約/方針提案
- PR を作って `@github pull request #...` でレビュー/変更点要約
- 変更の **影響範囲（呼び出し元/呼び出し先）** を質問してみる

## このサンプルのポイント
- `TaskRepository#saveTask(...)` に **意図的な欠陥**（null/整合性）があります
- `TaskService` / `TaskController` / `App` から呼ばれ、影響範囲が追いやすい構造です

## クイックスタート（5分）
1. GitHub で新規リポジトリを作成（例: `copilot-github-lab`）
2. このZIPを展開して中身をpush（`main` に）
3. GitHubで Issue を作成（例: "saveTask nullでクラッシュ"）
4. Android Studio で Clone
5. Copilot Chat で `@github issue #1 を要約して` を実行

## 実行（任意）
本当に動かす必要はありませんが、動かすなら:
- Gradle tool window から `run` もしくはターミナルで `./gradlew run`

## 注意
- `@github` が使えるかどうかは **Copilotの契約/認証/権限** に依存します
- 会社/組織の private repo では SSO/権限設定が必要なことがあります
