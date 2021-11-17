## Description
- 중고거래 플랫폼인 '당근마켓'을 클론하는 프로젝트이다. 이 프로젝트는 안드로이드 공부와 백엔드 개발자와의 협업 경험이 목적인 프로젝트이다.
## Project Period
- 2주(10/30 ~ 11/12)
## Environment
#### FrameWork
- Android Studio
#### language
- Kotlin

## Used Library,Dependencies in Android Studio
- Glide , Retrofit , Okhttp , Gson , Firebase , Naver Maps SDK , Circleimageview , Indicatorseekbar , Swiperefreshlayout

## Used Api
#### 네이버 Maps Api
- 현재 위치에 접근하고 해당 위경도 좌표를 얻기위해서 사용 
#### 네이버 Reverse Geocoding Api
- 현재 위치에 대한 위경도 좌표를 지역으로 변환하기 위해 사용
#### 협업한 백엔드 개발자가 만든 Api
- 당근마켓의 메인기능은 이 api를 이용 

## Result
#### Layout
- 회원가입 , 홈 화면 , 채팅 화면 , 나의 당근페이지까지 레이아웃 완성(자세한 내용은 Activity_Description.md 참고 )
#### Main Function
##### 1. 거래기능
  - 게시글 추가
  - 채팅(이 부분은 백엔드에서 채팅관련 api가 프로젝트 기간동안 구현이 안되어서 더미데이터로 넣어서 구현)
  -  판매중 -> 거래완료로 바꾸게 하는 기능   
##### 2. 로그인 기능
  - 회원가입
  - 자동 로그인(jwt이용)
#### 3. 유저의 관심목록,판매내역 조회기능
  - 특정 게시글을 관심목록에 추가하고 삭제하는 기능
  - 내가 게시글을 올리면 판매내역 중 판매중 칸에 추가,
  - 내가 올린 게시글이 거래가 완료되면 판매내역 중 거래관료 칸에 추가되고 판매중칸에서 사라지게 

