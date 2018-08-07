# 2018 caspstne api server 

### Project Introduction 

* 본 API 서버는 한밭대학교 정보통신공학과 전자제어공학과 **차량 접촉사고 자동알림 시스템** 구현을 위한 서버입니다. 

* 본 프로젝트에서는 수집기, 디스플레이, 서버로 구성되어 있습니다. 

  * 수집기 : 차량에 부착되어 차량의 정보를 실시간으로 수집합니다. 
    * 평상시 : 가속도, 자이로, 충격센서, 속도, 시간 정보를 전달합니다. 
    * 사고시 : 사고경도, 가속도, 자이로, 충격, 온도, 위치, 시간 정보를 전달합니다. 
  * 디스플레이 : 옵션으로 선택할 수 있으며, 현재 상태를 표시하는데 사용합니다. 
  * 서버 : 수집된 데이터를 처리하고, 사고판단 및 사후 조치에 대한 로직을 반영합니다. 

  

### API SERVER 

* API의 역할은 크게 다음과 같습니다. 
  * 차량 데이터 수집 
  * 차량 데이터 가공 
  * 사고처리 
  * 회원관리 
  * 차량관리 
  * 푸시알림 
* API 기능에 대한 자세한 사용 정보는 다음 링크에서 확인할 수 있습니다. 
  * https://documenter.getpostman.com/view/2212048/RWM8UYBj
* 서버는 JAVA 10에 최적화 되어있습니다. 
* Fat Jar인 shadowJar으로 서버를 운영할 수 있습니다. 
* embedded Jetty

### TODO LIST 

- [ ] 
- [ ] 





// 

