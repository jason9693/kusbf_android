<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/512%20-%20Play%20Store.png" height=32/>  KUSBF 17/18 Season Android Application
====================================
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/logo.jpg" height=200/> <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/intro.jpg" height=200/>
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_info_real.jpg" height=200/>
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_kusbf_real.jpg" height=200/>
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/dev_info.jpg" height=200/>

Developer : Jason Yang( Yang-Kichang ), from S.Korea.

Preview
-------
* '17/18 kusbf' App service is installed and used by 143 people. (Jan 22th,2018) <br>
* Like 110 people/day logged in our server.<br>
* This Application consist of MVP pattern, But some codes are free from MVP for speed implementation.<br>
* All of UI/UX Design for Application Did by Developer(Yang), Using Zeplin, Sketch & other tools.<br>

Detail
------
* intro

  <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/intro.jpg" height=200/>
  
  * Model : Model in "intro" have some business logics, refine data for scattering to "main_info" & "kusbf_info".
  
  * View : View in "intro" have a "switch" roll to move MainActivity with JsonData or LoginActivity by existence of "user info" recieved from Presenter.
  
  * Presenter : in Presenter, it classify "user info" is registed or not in 'Realm DB" and request to Network if 'info' is exist, or request to View for change Activity to LoginActivity if not exist.
  
* MainActivity

  * main info

    <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_info_real.jpg" height=200/>
      
      * Model : Model in "main info" have some business logics, refine json data recieved by intro for scattering to view. data sets are divided according to a cardview unit.
  
      * View : At first, View in "main info" send rawData(in "main_info") to presenter, and scatter data recieved by presenter, divides data to UI views.  
  
      * Presenter : in Presenter, it refine rawData by card view's needs using Model, and send them to View.
      
      
  * kusbf info

    <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_kusbf_real.jpg" height=200/>  
    
    * Model : Model in "kusbf info" have some business logics, refine json data recieved by intro for scattering to 'Total Info' cardview and Top10 & UnivSort Recycler View's Adapter. It also divided according to a cardview unit.
  
    * View : View in "kusbf info" scatter data recieved by presenter to 'total score' and connect to Top10Adapter & UnivSortAdapter.
   
    * Presenter : in Presenter, it refine rawData by card view(Total Info) and Top10 & UnivSortAdapter's need using Model, and send them to View.
      
    * Top10 & UnivSort Adapter
    
        * Model : Have a roll for data recieved from 'kusbf info' to list.
        
        * View : Scattering list data from presenter to item views and holding itemviews.
        
        * Presenter : Having a data as list form by Model, and sending them to View. 
        
Used Library & Api 
-----------------

  * <a href="https://github.com/realm/realm-java">Realm</a>
  
  * <a href="https://github.com/google/volley">Volley</a>
  
  * <a href="https://github.com/bumptech/glide">Glide</a>
  
  * <a href="https://github.com/hdodenhof/CircleImageView">CircleImageView</a>
  

Licence
------
Project is published under the MIT licence. Feel free to clone and modify repo as you want, but don'y forget to add reference to authors :)





<a href="https://play.google.com/store/apps/details?id=com.notisnow.kusbf.warrior">Go to PlayStore "KUSBF"</a>

<br><br>
한국어 문서 ( Korean Doc )
--------

<br><br>




<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/512%20-%20Play%20Store.png" height=32/>  KUSBF 17/18 Season 안드로이드 어플리케이션 (KOR)
====================================
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/logo.jpg" height=200/> <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/intro.jpg" height=200/>
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_info_real.jpg" height=200/>
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_kusbf_real.jpg" height=200/>
<img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/dev_info.jpg" height=200/>

개발자 : 양기창

Preview
-------
* 17/18 kusbf어플은 2018.1.22 현재 총 143명이 설치및 사용중인 어플리케이션이며,<br>
* 하루 서버 접속 인원은 평균 110명 정도 됩니다.<br>
* 앱은 MVP패턴으로 작성되었으며, 개발기간을 단축하기 위해 일부 mvp의 디자인적 요소는 배제하였습니다.<br>
* 모든 어플의 디자인은 본 개발자(양기창)가 직접 하였으며, Zeplin, Sketch를 사용하여 디자인 하였습니다.<br>

Detail
------
* intro

  <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/intro.jpg" height=200/>
  
  * Model : intro의 모델에서는 네트워크에서 받아온 json을 "main_info"와 "kusbf_info"로 뿌리기 위한 데이터 가공처리를 하는 비즈니스 로직을 담습니다.
  
  * View : intro의 view 에서는 presenter에서 전송하는 user info 등록 여부에 따라 로그인 화면으로 가거나 / 받아온 json을 통하여 main Activity로 이동하는 
  역할을 합니다.
  
  * Presenter : Presenter에서는 realm데이터 베이스상의 user info 등록 여부를 판별하여 등록된 유저가 있으면 Network에 fetch 요청을 보내고, 등록된 유저가 없을 시,
  view에 로그인 화면으로 화면을 이동하는 요청을 보냅니다.
  
* MainActivity

  * main info

    <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_info_real.jpg" height=200/>
      
      * Model : main info 의 모델에서는 intro 에서 받아온 json("main_info")를 최종적으로 view에 뿌리기 위한 데이터 가공처리를 하는 비즈니스 로직을 담습니다.
      이때, 각 card의 데이터 뭉치 단위로 데이터를 움직입니다.
  
      * View : main info 의 view 에서는 받아온 main_info의 rawData를 presenter에 전송한 뒤,
      presenter에서 model을 활용하여 분류한 데이터들을 받아와서 각각의 view에 뿌려주어 표시합니다. 
  
      * Presenter : Presenter에서는 view에서 넘겨받은 rawData를 각각의 card view에서 필요한 데이터에 알맞게 Model을 활용하여 가공 및 분류한뒤, 뷰에 뿌려줍니다.
      
  * kusbf info

    <img src = "https://github.com/gichang-yang/kusbf_readme_resource/blob/master/screen_shot/main_kusbf_real.jpg" height=200/>  
      
      * Model : kusbf info 의 모델에서는 intro 에서 받아온 json("kusbf_info")를 최종적으로 연합 총 점수card에 뿌리기 위한 데이터 가공처리 및 Top10 & UnivSort Recycler View 의 Adapter에 데이터를 던지기 위한
      비즈니스 로직을 담습니다.
      이때, 역시 각 card의 데이터 뭉치 단위로 데이터를 움직입니다.
  
      * View : main info 의 view 에서는 받아온 kusbf_info의 rawData를 presenter에 전송한 뒤,
      presenter에서 model을 활용하여 분류한 데이터들을 받아와서 total score 에 뿌려주고, Top10Adapter, UnivSortAdapter과 연결합니다. 
  
      * Presenter : Presenter에서는 view에서 넘겨받은 rawData를 각각의 Total info,Adapter에 필요한 데이터에 알맞게 데이터를 분류및 Model을 활용하여 가공하여 
      view에 전달합니다.
      
      * Top10 & UnivSort Adapter
        
        * Model : kusbf info에서 받은 데이터를 adapter의 list에 담기위한 가공처리를 담당합니다.
        
        * View : presenter에서 받은 데이터의 list들을 각각의 item에 뿌려주며 view들을 holding합니다.
        
        * Presenter : 데이터들을 list형태로 소유하고 있으며, 이는 model에서 가공된 정보들 입니다. view에 정보(list)를 전달합니다.
        
사용 라이브러리 및 api
-----------------

  * <a href="https://github.com/realm/realm-java">Realm</a>
  
  * <a href="https://github.com/google/volley">Volley</a>
  
  * <a href="https://github.com/bumptech/glide">Glide</a>
  
  * <a href="https://github.com/hdodenhof/CircleImageView">CircleImageView</a>
  

라이선스
------
Project is published under the MIT licence. Feel free to clone and modify repo as you want, but don'y forget to add reference to authors :)


<a href="https://play.google.com/store/apps/details?id=com.notisnow.kusbf.warrior">kusbf전투력 측정기 PlayStore 이동</a>

<br><br><br>
