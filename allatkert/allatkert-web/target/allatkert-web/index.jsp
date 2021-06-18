<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@ include file="head.jsp" %>
    <link rel="stylesheet" href="css/style3.css">
    <title>Vadaspark</title>
</head>
<body>
<div>
    <h1>Üdvözlünk a szegedi vadaspark honlapján!</h1>

</div>
<div class="container">
    <h2>Regisztrálj, ha még nem tetted meg!</h2>

    <form action="Regist" method="post" >
        <div class="form-group">
            <label for="nev">Név</label>
            <input required name="nev" type="text" class="form-control" id="nev"
                   placeholder="Nev"/>
        </div>
        <div class="form-group">
            <label for="email">E-mail cím</label>
            <input required name="email" type="email" class="form-control" id="email"
                   placeholder="Email"/>
        </div>

        <form action="listAllatok.jsp" method="post">
            <button  id="submit1" type="submit" class="button">Regisztrálok!</button>
        </form>

    </form>
</div>

<div class="lista">
    <h3>Nézd meg milyen állatok vannak a vadasparkban:</h3>
    <form  action="pages/listAllatok.jsp" method="post">
        <button class="gomb1" id="submit" type="submit" class="btn btn-primary">Állatok listája</button>
    </form>

</div>

<div class="szoveg">
    <h3>Szegedi vadaspark története</h3>
    <p>A Szegedi Vadaspark megépülése nagyon lassan haladt, míg végül 1989. május 28-án megnyithatta kapuit a nagyközönség előtt,
        akkor még mindössze 3 hektáros bemutatóként. A szegényes anyagiak miatt nem gondolkozhattak nagy testű fajok bemutatásában, így
        született meg az a koncepció, melynek köszönhetően a Szegedi Vadaspark ma is egyedülálló állománnyal bír a hazai állatkertek körében.
        Elsősorban kistestű fajok tartására szakosodtak, melyek közül a karmosmajmok tartásában és tenyésztésében rövidesen nemzetközi sikereket is
        elértek. 1992-ben kezdhették meg a jelentősebb fejlesztéseket. Ennek első eredménye az 1993-ban átadott oktatóterem volt.
        A vadaspark a környezeti nevelést a kezdetek óta igen magas szinten műveli, így e téren a térség kiemelkedő központjává nőtte ki magát.</p>

        <p>2000-ben fejeződött be az araház és -röpde építése valamint elkészült a japán makákók hatalmas, természetes erdei kifutója és a kiangok férőhelye.
            A 2001-es év igazi szakmai szenzációja volt, hogy a sörényes farkasok szaporodtak a parkban.2002-ben újra jelentős szakmai sikert jelentett,
            hogy a fekete bőgőmajmoknak is kölykük született. Ugyanebben az évben készült el a hópárducok tágas férőhelye, ahol azóta a pár már kölyköket is
            nevelt. 2003-ban korszerűsítették az egykori majomházat, amelyet az Atlanti Esőerdő házává alakítottak. 2004-től sorra épültek az állatok
            megfelelő teleltetését szolgáló épületek. Elkészült az Ázsia-ház, mely a majomszigeteken élő gibbonok és wanderuk belső férőhelyéül szolgál.
            Majd felépült a Dél-Amerika-ház, melyben a bőgő- és pókmajmok, a tapírok és a vízidisznók kaptak szállást. 2005-ben az Afrika-részen épült ház
            és kifutó az újonnan érkezett oroszlánoknak, valamint külön épület és kifutók a szurikátáknak és a sarkantyús teknősöknek. Az év végén értékes
            állatfajokkal is gazdagodott a park gyűjteménye: az Oroszlánházba foltos hiénák érkeztek, a kínai víziőzek pedig tágas erdei kifutót kaptak.
            2006-ban tovább bővült az Afrika-rész: Madagaszkár-ház és Flamingó-ház épült.</p>

    <p>2007-ben került átadásra a Jaguár ház és kifutó, valamint felújításra került a Zoosuli/terráriumház. 2008-ban megnyílt az új Főbejárat, valamint
        az afrikai rész is bővült gepárd, cerkóf, tompaorrú krokodil és pintybemutatóval. Szintén ekkor került átadásra a rozsomák kifutó. 2009-ben pedig
        szibériai tigris ház és kifutó, valamint észak-kínai leopárd kifutó épült. 2010-ben szürke farkas, vidra, aranysakál kifutók és madárröpdék, hangyász
        és pókmajomkifutók, 2011-ben pedig a Zsiráfház került átadásra. 2012-ben Pingvinbemutató, Ázsia-ház felújítása új kifutókkal ködfoltos párduc, binturong,
        kis panda kifutó, 2013-ban borjúfóka bemutató, Etióp-bemutató (füles és fehérhátú keselyűk, dzseláda páviánok és szirti borzok) épült. 2014-ben kültéri
        terráriumokban a világ harmadik állatkertjeként rákosi viperát mutat be, emellett felépült egy nagy, hazai szarvasfajokat és muflonokat bemutató kifutó is.
        2015-ben a barna medvéknek, valamint tarvarjaknak és mormotáknak otthont adó helyek épültek. 2016-ban fakúszó sülökkel és társas prérikutyákkal gazdagodott a gyűjtemény.

        2018-ban a Modern Városok Program keretében ázsiai elefánt ház került átadásra, a bemutatóban pápua szarvascsőrű madarak, kiskarmú vidrák is láthatók.

        2020-ban zergék érkeztek.</p>

</div>
</body>
</html>
