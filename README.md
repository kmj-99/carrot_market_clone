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
`<?xml version="1.0" encoding="utf-8"?>
  <shape
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape="rectangle">
  <solid android:color="@color/carrot_color" />
  <size android:width="1.5dp" />
  </shape>
`