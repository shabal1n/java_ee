<%--
  Created by IntelliJ IDEA.
  User: arturshabalin
  Date: 01.05.2022
  Time: 01:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>Restaurants</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/logo.png"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <!-- animate CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/animate.css"/>
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css"/>
    <!-- themify CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/themify-icons.css"/>
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flaticon.css"/>
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/magnific-popup.css"/>
    <!-- swiper CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/slick.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/gijgo.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/nice-select.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/all.css"/>
    <!-- style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>
<header class="main_menu home_menu">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="main.html">
                        <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="logo"/>
                    </a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse main-menu-item justify-content-end"
                         id="navbarSupportedContent">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="restaurants">Restaurants</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Categories
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="blog.html">Blog</a>
                                    <a class="dropdown-item" href="single-blog.html">Single blog</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="map">Map</a>
                            </li>
                        </ul>
                    </div>
                    <div class="social_icon d-none d-lg-block">
                        <a href="#" class="single_social_icon"><i class="fa fa-search"></i></a>
                        <a href="#" class="single_social_icon"><i class="fa fa-user"></i></a>
                        <!-- <a href="#" class="single_social_icon"><i class="fab fa-instagram"></i></a> -->
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>
<!-- Header part end-->

<!-- breadcrumb start-->
<section class="breadcrumb breadcrumb_bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb_iner">
                    <div class="breadcrumb_iner_item">
                        <p>Restaurants</p>
                        <h2>Menu Items</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- breadcrumb start-->

<!-- food menu part start-->
<section class="food_menu">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-12">
                <div class="single-member">
                    <div class="row">
                        <div class="col-sm-6 col-lg-6">
                            <div class="single_food_item media">
                                <img src="${pageContext.request.contextPath}/resources/img/food_menu/single_food_1.png"
                                     class="img-responsive" alt="...">
                                <div class="media-body align-self-center">
                                    <h3>Pork Sandwich</h3>
                                    <p>They're wherein heaven seed hath nothing</p>
                                    <h5>Form $40.00</h5>
                                </div>
                            </div>
                            <div class="single_food_item media">
                                <img src="${pageContext.request.contextPath}/resources/img/food_menu/single_food_2.png"
                                     class="img-responsive" alt="...">
                                <div class="media-body align-self-center">
                                    <h3>Roasted Marrow</h3>
                                    <p>They're wherein heaven seed hath nothing</p>
                                    <h5>Form $40.00</h5>
                                </div>
                            </div>
                            <div class="single_food_item media">
                                <img src="${pageContext.request.contextPath}/resources/img/food_menu/single_food_3.png"
                                     class="img-responsive" alt="...">
                                <div class="media-body align-self-center">
                                    <h3>Summer Cooking</h3>
                                    <p>They're wherein heaven seed hath nothing</p>
                                    <h5>Form $40.00</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-6">
                            <div class="single_food_item media">
                                <img src="${pageContext.request.contextPath}/resources/img/food_menu/single_food_4.png"
                                     class="img-responsive" alt="...">
                                <div class="media-body align-self-center">
                                    <h3>Easter Delight</h3>
                                    <p>They're wherein heaven seed hath nothing</p>
                                    <h5>Form $40.00</h5>
                                </div>
                            </div>
                            <div class="single_food_item media">
                                <img src="${pageContext.request.contextPath}/resources/img/food_menu/single_food_5.png"
                                     class="img-responsive" alt="...">
                                <div class="media-body align-self-center">
                                    <h3>Tiener Schnitze</h3>
                                    <p>They're wherein heaven seed hath nothing</p>
                                    <h5>Form $40.00</h5>
                                </div>
                            </div>
                            <div class="single_food_item media">
                                <img src="${pageContext.request.contextPath}/resources/img/food_menu/single_food_6.png"
                                     class="img-responsive" alt="...">
                                <div class="media-body align-self-center">
                                    <h3>Chicken Roast</h3>
                                    <p>They're wherein heaven seed hath nothing</p>
                                    <h5>Form $40.00</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- food menu part end-->

<!-- footer part start-->
<footer class="footer-area">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-xl-3 col-sm-6 col-md-3 col-lg-3">
                <div class="single-footer-widget footer_1">
                    <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="#"/>
                    <p>+880 253 356 263</p>
                    <span>burires@contact.com</span>
                    <div class="social_icon">
                        <a href="#" class="single_social_icon"><i class="fab fa-facebook-square"></i></a>
                        <a href="#" class="single_social_icon"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 col-md-2 col-lg-3">
                <div class="single-footer-widget footer_2">
                    <h4>Quick links</h4>
                    <div class="contact_info">
                        <ul>
                            <li><a href="#">About</a></li>
                            <li><a href="#"> Menu</a></li>
                            <li><a href="#">Reservation</a></li>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#"> Breakfast</a></li>
                            <li><a href="#">Lunch</a></li>
                            <li><a href="#">Dinner</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 col-md-4 col-lg-3">
                <div class="single-footer-widget footer_3">
                    <h4>Subscribe newsletter</h4>
                    <form action="#">
                        <div class="form-group">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="Email Address"
                                       onfocus="this.placeholder = ''"
                                       onblur="this.placeholder = 'Email Address'"/>
                                <div class="input-group-append">
                                    <button class="btn" type="button">
                                        <i class="fas fa-paper-plane"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <p>
                        Subscribe newsletter to get all updates about discount and
                        offers.
                    </p>
                </div>
            </div>
        </div>
        <div class="copyright_part_text">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p class="footer-text m-0">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;
                        <script>document.write(new Date().getFullYear());</script>
                        All rights reserved | This template is made
                        with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com"
                                                                               target="_blank">Colorlib</a>.Downloaded
                        from <a href="https://themeslab.org/"
                                target="_blank">Themeslab</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- footer part end-->

<!-- jquery plugins here-->
<!-- jquery -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- easing js -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.magnific-popup.js"></script>
<!-- swiper js -->
<script src="${pageContext.request.contextPath}/resources/js/swiper.min.js"></script>
<!-- swiper js -->
<script src="${pageContext.request.contextPath}/resources/js/masonry.pkgd.js"></script>
<!-- particles js -->
<script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
<!-- swiper js -->
<script src="${pageContext.request.contextPath}/resources/js/slick.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/gijgo.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.nice-select.min.js"></script>
<!-- custom js -->
<script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</body>

</html>
