# 2021-10-30 진행상황
- 앱 시작화면 구현
- 앱 로딩화면 구현 : Dialog를 이용하여 구현
- 앱 로딩 중일 때 화면과 로딩이 끝난 후의 화면을 보여주는 로직 구현 : 아직 API개발이 안되어서 임시로 더미데이터 사용

### 1주차 피드백까지의 진행율
- 20%정도 진행

### 현재 구현중인 기능
- 회원가입기능과 레이아웃 짜기

### 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
- 현재까지 특별한 회의진행은 안함 

### 개발 도중에 발생한 이슈
#### 발생한 이슈
- EditText에 포커스가 갔을 때 커서의 색깔, 드래그 할 떄의 색깔 , 드래그 할 때 밑에 두개의 아이콘색깔 변경이 잘 안됨
- 구글링에 나와있는 방법들을 써봐도 색상 변경이 안 되어서 꽤 삽질을 함
#### 해결방법
밑에 코드를 이용해서 해결
- `android:textColorHighlight="@color/edit_drag_color"` : 드래그 할 때 색깔을 정하는 코드
- `android:textCursorDrawable="@drawable/cursor"`        : 드래그가 되었을때 밑에 두개의 아이콘의 색깔을 정하는 코드
##### @drawable/cursor  
`<?xml version="1.0" encoding="utf-8"?>`  
  `<shape`  
  `xmlns:android="http://schemas.android.com/apk/res/android"`  
  `android:shape="rectangle">`  
  `<solid android:color="@color/carrot_color" />`  
  `<size android:width="1.5dp" />`  
`</shape>`  




# 2021-10-31 진행상황
- 회원가입과 관련한 레이아웃을 완성
- 네이버 map api , 네이버 Rc api를 이용해서 현재 위치의 좌표를 따서 지역으로 변환하여 서버로 전달할 준비 완료
- 아직 서버쪽에서 api가 완성이 되지않아서 일단 더미데이터를 넣어놨고 , api가 완성이 되면 바로 적용할 수 있게끔 코드를 작성해놨다.

## 2021-10-31 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 현재 위치를 접근해서 주변반경에 있는 지역을 보여주는 기능에 대한 합의점
- 클라이언트에서 현재 위치에 대한 좌표,지역(ex- 서울 성북구)을 보내주면 서버에서는 주변반경에 대한 데이터를 보내주는 걸로 합의점을 찾음

## 1주차 피드백까지의 진행율
- 회원가입/ 로그인 API 연동 : 30%(아직 api완성이 안됨)
- 로그인/회원가입 화면 : 100%
- 뼈대 레이아웃 구성(네비게이션, 탭, 등) : 10% 

## 현재 구현중인 기능
- 전체적인 레이아웃 뼈대 구성


## 개발 도중에 발생한 이슈
- 이번엔 이슈라기보단 꽤 삽질을 했던 부분이 있었다.
#### 삽질한 부분
- 현재 위치좌표를 얻어서 주소로 변환해야 하기위해 네이버 map api를 계속 건드려봤다. 하지만 풀리지 않았다.
#### 해결방법
- 지오코딩이라는 네이버 좌표->주소 변환 api가 있었다. 이 api를 이용해서 바로 해결했다.

  
# 2021-11-01 진행상황
- 회원가입과 관련한 레이아웃을 완성했고 api만 완성이 되면 바로 연결 할 수 있게끔 설계를 짰다.
- 전체적인 레이아웃 뼈대를 만들었고, 홈화면과 동네생활 화면은 대략 설계를 함

## 2021-11-01 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 회원가입에 대해 합의점
- 클라이언트 쪽에서 모든 자동로그인을 구현하는 걸로 결정
- 데이터 같은 경우 회원가입 로지을 다 끝낸 후 마지막에 한 번에 보내는 걸로 결정

## 1주차 피드백까지의 진행율
- 회원가입/ 로그인 API 연동 : 80%(나머지 20%는 api이다.)
- 로그인/회원가입 화면 : 100%
- 뼈대 레이아웃 구성(네비게이션, 탭, 등) :100%

## 현재 구현중인 기능
- 프로필 설정 화면 구현 중(회원가입)


## 개발 도중에 발생한 이슈
- 회원가입 화면에서 등록되어 있지 않은 사용자에 대해서 `프로필설정`화면을 거쳐가는 걸 오늘 알았다.
- 난 그동안 로그아웃 하고 다시 회원가입 하는 식으로 테스팅을 해서 프로필설정 화면이 있는 줄도 몰랐다. 그래서 현재 이 부분을 구현중이다.  



# 2021-11-02 진행상황
- 현재 홈 화면과 상품 상세화면을 짜고있는 중이다. 


## 2021-11-02 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 현재 지역을 보낼 때의 형식에 관한 합의점
- 본래 `충남 부여군` 의 형시이었다면 좀 더 자세하게 `충남 부여군 규암면 오소리 `로 데이터를 보내주기로 합의했다.


## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 50%
- 거래기능 : 0%
- 채팅 : 0%


## 현재 구현중인 기능
- 현재 상품상세정보화면의 디테일을 구현중이다.


## 개발 도중에 발생한 이슈
#### Glide 이슈
- Glide를 사용해서 이미지를 올리는 데 화면에 꽉채워지지 않는다.
#### 해결
- centeCrop()메소드를 사용하니까 해결이 되었다.  



# 2021-11-03 진행상황
- 홈 화면과 상품상세화면 레이아웃은 다 완성했고 api만 엮으면된다.
- 채팅은 레이아웃은 서로 대화하는 기능만 구현하면 된다. 나머지 레이아웃은 다 짰다.
- 거래기능은 포스팅을 하는 레이아웃을 짜고 있는데 여기서 EditText관련 이슈가 생겼다.


## 2021-11-03 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### api공유
- 화원가입 관련 api가 구축이 되어서 그거에 관련해서 서로 공유를 하였다.

## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 80%(api만 엮으면 됨)
- 거래기능 : 30%
- 채팅 : 30%


## 현재 구현중인 기능
- 회원가입 api가 나와서 api를 화면에 엮는 기능을 구현하고 있다.


## 개발 도중에 발생한 이슈
#### EditTExt 이슈
- EditText에서 키보드가 올라갈 때 레이아웃이 가려지느 이슈
#### 시도한 방법
- 매니페스트에 각종 플러그설정을 해보았지만 잘 안됨
#### 지식인
- 루트 레이아웃을 contraint로 잡고  contraint bottom of bottom을 설정을 해보라는 답변을 얻었다. 내일 해봐야겠다. 


# 2021-11-04 진행상황
- 현재 채팅레이아웃도 완성을 했고 api만 엮으면 된다.
- 거래기능 같은 경우 포스팅하는 기능은 거의 완성을 했고 이걸 마이 당근 페이지와 연동하거나등등 부가적인 기능은 아직 구현하는 중이다.


## 2021-11-04 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 별다른 내용은 없음


## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 80%(api만 엮으면 됨)
- 거래기능 : 50%
- 채팅 : 80% 


## 현재 구현중인 기능
- 회원가입 할 때 주변 지역을 검색하는 api가 약간 수정이 되어서 수정된 부분을 토대로 다시 짜고있다.


## 개발 도중에 발생한 이슈
### 특별한 이슈는 없었음


# 2021-11-05 진행상황
- 중고거래 게시글을 추가하는 api가 아직 완성이 되지 않아서 다른 디테일 부분을 구현하고 있다.
- 검색,글쓰기,나의당근페이지,채팅 레이아웃을 완성했다.


## 2021-11-05 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 별다른 내용은 없음


## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 80%(api만 엮으면 됨)
- 거래기능 : 70% (api만 엮으면 됨)
- 채팅 : 80% (api만 엮으면 됨)


## 현재 구현중인 기능
- 현재 홈 화면에서 카테고리 레이아웃을 구성하고 있다.


## 개발 도중에 발생한 이슈
### 특별한 이슈는 없었음  




# 2021-11-06 진행상황
- 나의 당근에서 프로필 수정 부분을 구현 중
- 홈 화면 -> 카테고리 레이아웃 완성
- 내 근처 화면의 기능들은 모두 완성해고 세세한 디테일만 잡으면 된다.
- 아직 포스팅 api가 나오지 않아아 게시물 관련 api를 테스트 하지 못하고 있다.


## 2021-11-06 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 별다른 내용은 없음


## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 80%(api만 엮으면 됨)
- 거래기능 : 70% (api만 엮으면 됨)
- 채팅 : 80% (api만 엮으면 됨)


## 현재 구현중인 기능


## 개발 도중에 발생한 이슈
### 특별한 이슈는 없었음  



# 2021-11-07 진행상황
- 게시글 관련 api를 모두 엮었다.
- 내 동네 설정에서 시크바를 사용해서 주변 동네 설정을 한느 기능을 구현중이다.
- 아직 채팅관련 api가 안 나와서 구현을 못하고 있다. 


## 2021-11-07 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 이미지를 어떻게 보내는 가에 대한 회의록
- 클라이언트에서 이미지를 파이어 베이스에 올려서 파이어 베이스의 url을 보내는 걸로 결론이 났다.


## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 90%
- 거래기능 : 90% 
- 채팅 : 80% (api만 엮으면 됨)


## 현재 구현중인 기능
- 현재 내 동네 설정을 하는 기능을 구현하고 있다

## 개발 도중에 발생한 이슈
- 이슈라기 보다는 파이어베이스를 사용해야 하는 경우가 생겨서 이걸 사용하는 데 애를 먹었다..





# 2021-11-08 진행상황
- 현재 내 동네 설정에서 시크바를 사용해서 주변 동네 범위 설정을 하는 기능을 구현했다.
- 아직 채팅관련 api가 안 나와서 구현을 못하고 있다.
- 관심목록 추가,삭제 api , 동네 범위 api , 내가 설정한 동네에서 올라온 게시글 api를 엮었다.


## 2021-11-08 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 자동로그인
- 이 부분은 원래 기획할 때 서버단에서 구현이 만만치 않아서 빼고 클라이언트에서 jwt를 저장했다가 계속 사용하는 걸로 했다.
- 하지만 이런식으로 구현하면 자동로그인에 대한 의미가 사라진다. 그래서 멘토님이 피드백을 주셨고 다시 이야기를 나누었다.   
- 이 부분은  서버에서 자동로그인 로직을 구현하고 클라이언트에서은 jwt를 보내 서버에서 자동로그인으로 검증,확인하기로 결정했다.


## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 100%
- 거래기능 : 90% (구매를 어떤식으로 해야 할 지 고민)
- 채팅 : 80% (api만 엮으면 됨)


## 현재 구현중인 기능
- api 명세서에 있는 api들을 하나씩 적용을 시키는 중이고, 현재 주소관련 api를 적용시키고 있다. 

## 개발 도중에 발생한 이슈
- 별다른 이슈는 없었지만 api를 엮는 건 간단한 작업일 줄 알았다.
- 하지만 api가 복잡하게 얽혀있어서 로직들을 정확히 파악하고 유현하게 나의 코드에 적용시키는 게 생각보다 시간이 많이 들어간다.
- 그래서 레이아웃을 더 짜기보다는 일단 api를 모두 엮는거에 집중을 해야겠다는 생각이 들었다.





# 2021-11-09 진행상황
- 아직 채팅관련 api가 안 나와서 구현을 못하고 있다.
- 유저정보 조회 api를 엮었고 레이아웃의 디자인을 개선하는 작업을 했다.

## 2021-11-09 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 



## 2주차 피드백까지의 진행율
- 홈화면,상품상세화면 : 100%
- 거래기능 : 80% (구매관련 api가 아직 안나옴)
- 채팅 : 80% (api만 엮으면 됨)


## 현재 구현중인 기능
- 현재 거래기능과 레이아웃의 디테일한 부분을 신경을 쓰고 있다.

## 개발 도중에 발생한 이슈
- 별다른 이슈는 없었다.



# 2021-11-10 진행상황
- 채팅관련 api가 나와서 모두 엮었다.


## 2021-11-10 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 



## 데드라인까지의 진행율
- 홈화면,상품상세화면 : 100%
- 거래기능 : 90% 
- 채팅 : 90% 


## 현재 구현중인 기능
- 디테일 한 부분을 구현 중

## 개발 도중에 발생한 이슈
- 별다른 이슈는 없었다.





  

# 2021-11-11 진행상황
- 거의다 완성을 했지만 많이 부족해 보인다.. 그래도 열심히 해서 후회는 없다


## 2021-11-11 클라이언트 개발자 or 서버 개발자와의 회의에 따른 회의록
### 



## 데드라인까지의 진행율
- 홈화면,상품상세화면 : 100%
- 거래기능 : 100%
- 채팅 : 100%


## 현재 구현중인 기능
- 당근마켓의 주요기능은 구현을 했다.

## 개발 도중에 발생한 이슈
- 별다른 이슈는 없었다.


  



