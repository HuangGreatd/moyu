package com.juzipi.common;

/**
 * 返回工具类
 *
 * @author juzipi
 * @date 2024/7/15 22:16
 */
public class ResultUtils {
	/**
	 * 成功
	 * @param data
	 * @return
	 * @param <T>
	 */
	public static <T> BaseResponse<T> success(T data) {
		return new BaseResponse<>(0, data, "success");
	}
	
	/**
	 * 失败
	 * @param code
	 * @param message
	 * @return
	 */
	public static BaseResponse error(int code, String message) {
		return new BaseResponse(code, message);
	}
	
	/**
	 * 失败
	 * @param errorCode
	 * @return
	 */
	public static BaseResponse error(ErrorCode errorCode){
		return new BaseResponse(errorCode);
	}
	
	/**
	 * 失败
	 * @param errorCode
	 * @param message
	 * @return
	 */
	public static BaseResponse error(ErrorCode errorCode,String message){
		return new BaseResponse(errorCode.getCode(),null,message);
	}
	
	
}
