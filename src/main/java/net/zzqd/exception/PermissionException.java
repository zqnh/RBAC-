package net.zzqd.exception;

/**
 * @author zqnh
 * @date 2019/8/9 on 20:53.
 */
public class PermissionException extends RuntimeException
{
    public PermissionException()
    {
        super();
    }

    public PermissionException(String message)
    {
        super(message);
    }

    public PermissionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PermissionException(Throwable cause)
    {
        super(cause);
    }

    protected PermissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
