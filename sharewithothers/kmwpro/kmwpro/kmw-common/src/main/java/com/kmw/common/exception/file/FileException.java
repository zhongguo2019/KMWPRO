package com.kmw.common.exception.file;

import com.kmw.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author kmw
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
