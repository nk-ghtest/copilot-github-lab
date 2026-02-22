package lab.exception;

/**
 * タスクの入力値が不正な場合にスローされる例外。
 * RuntimeException を継承しているため、呼び出し元での catch は任意。
 */
public class InvalidTaskException extends RuntimeException {
    public InvalidTaskException(String message) {
        super(message);
    }
}
