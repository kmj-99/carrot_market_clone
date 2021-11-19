## 1. Description
- 중고거래 플랫폼인 '당근마켓'을 클론하는 프로젝트이다. 이 프로젝트는 안드로이드 공부와 백엔드 개발자와의 협업 경험이 목적인 프로젝트이다.
## 2. Project Period
- 2주(10/30 ~ 11/12)
## 3. Environment
#### FrameWork
- Android Studio
#### language
- Kotlin

## 4. Used Library,Dependencies in Android Studio
- Glide , Retrofit , Okhttp , Gson , Firebase , Naver Maps SDK , Circleimageview , Indicatorseekbar , Swiperefreshlayout

## 5. Used Api
#### 네이버 Maps Api
- 현재 위치에 접근하고 해당 위경도 좌표를 얻기위해서 사용 
#### 네이버 Reverse Geocoding Api
- 현재 위치에 대한 위경도 좌표를 지역으로 변환하기 위해 사용
#### 협업한 백엔드 개발자가 만든 Api
- 당근마켓의 메인기능은 이 api를 이용 

## 6. Used Design Pattern
- MVP Pattern  
## 7. Result
#### Layout
- 회원가입 , 홈 화면 , 채팅 화면 , 나의 당근페이지까지 레이아웃 완성(자세한 내용은 Activity_Description.md 참고 )
#### 6-1. 주요기능
##### 1. 거래기능
  - 게시글 추가
  - 채팅(이 부분은 백엔드에서 채팅관련 api가 프로젝트 기간동안 구현이 안되어서 더미데이터로 넣어서 구현)
  -  판매중 -> 거래완료로 바꾸게 하는 기능   
##### 2. 로그인 기능
  - 회원가입
  - 자동 로그인(jwt이용)
##### 3. 유저의 관심목록,판매내역 조회기능
  - 특정 게시글을 관심목록에 추가하고 삭제하는 기능
  - 내가 게시글을 올리면 판매내역 중 판매중 칸에 추가,
  - 내가 올린 게시글이 거래가 완료되면 판매내역 중 거래완료 칸에 추가되고 판매중칸에서 사라지게 구현

#### 6-2. 그 이외에 기능
- 사용자의 현재 위치를 접근해서 위경도 죄표를 얻은다음 지역으로 바꿔서 주변 동네를 가져와서 화면에 띄워주는 기능
- 사용자의 갤러리에 접근을 해서 선택된 이미지를 파이어베이스를 이용해 DB에 저장을 해서 꺼내쓸 수 있도록 만들었다.
