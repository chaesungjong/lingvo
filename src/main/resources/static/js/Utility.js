
/**
 * api 통신 공통 함수
 * @param {API 주소}  url 
 * @param {데이터}    data 
 * @param {성공 콜백} successCallback 
 * @param {실패 콜백} errorCallback 
 */

function ajaxRequest(url, data, successCallback, errorCallback) {
    $.ajax({
      url: url,
      method: "GET",
      data: data,
      dataType: "json",
      success: successCallback,
      error: errorCallback
    });
  }
  
/**
 * //https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
 * 위도 경도를 통하여 날씨 정보 가져오기 
 * @param   {위도} lat
 * @param   {경도} lon
 * @param   {성공 콜백} successCallback 
 * @param   {실패 콜백} errorCallback 
 */
function weatherInformation(lat, lon,successCallback, errorCallback){
   
    ajaxRequest(
        "https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=f6fa61e6765ddf15ab5fc2c22b062493",
        null,
        successCallback,
        errorCallback
      );
}