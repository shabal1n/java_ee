<%--
  Created by IntelliJ IDEA.
  User: arturshabalin
  Date: 01.05.2022
  Time: 01:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <title>Map</title>
    <link rel="icon" href="resources/img/logo.png"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
    <!-- animate CSS -->
    <link rel="stylesheet" href="resources/css/animate.css"/>
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css"/>
    <!-- themify CSS -->
    <link rel="stylesheet" href="resources/css/themify-icons.css"/>
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="resources/css/flaticon.css"/>
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="resources/css/magnific-popup.css"/>
    <!-- swiper CSS -->
    <link rel="stylesheet" href="resources/css/slick.css"/>
    <link rel="stylesheet" href="resources/css/gijgo.min.css"/>
    <link rel="stylesheet" href="resources/css/nice-select.css"/>
    <link rel="stylesheet" href="resources/css/all.css"/>
    <!-- style CSS -->
    <link rel="stylesheet" href="resources/css/style.css"/>
</head>

<body>
<header class="main_menu home_menu">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="/">
                        <img src="resources/img/logo.png" alt="logo"/>
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
                        <p>home. contact</p>
                        <h2>cantact us</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- breadcrumb start-->

<!-- ================ contact section start ================= -->
<section class="contact-section section_padding">
    <div class="container">
        <div class="d-none d-sm-block mb-5 pb-4">
            <div id="map" style="height: 480px;"></div>
            <script>
                function initMap() {
                    var uluru = {
                        lat: -25.363,
                        lng: 131.044
                    };
                    var grayStyles = [
                        {
                            featureType: "all",
                            stylers: [
                                {
                                    saturation: -90
                                },
                                {
                                    lightness: 50
                                }
                            ]
                        },
                        {
                            elementType: "labels.text.fill",
                            stylers: [
                                {
                                    color: "#ccdee9"
                                }
                            ]
                        }
                    ];
                    var map = new google.maps.Map(document.getElementById("map"), {
                        center: {
                            lat: -31.197,
                            lng: 150.744
                        },
                        zoom: 9,
                        styles: grayStyles,
                        scrollwheel: false
                    });
                }
            </script>
            <script
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDpfS1oRGreGSBU5HHjMmQ3o5NLw7VdJ6I&callback=initMap"></script>
        </div>

        <div class="row">
            <div class="col-12">
                <h2 class="contact-title">Get in Touch</h2>
            </div>
            <div class="col-lg-8">
                <form class="form-contact contact_form" action="contact_process.php" method="post" id="contactForm"
                      novalidate="novalidate">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                  <textarea class="form-control w-100" name="message" id="message" cols="30" rows="9"
                            onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Message'"
                            placeholder="Enter Message"></textarea>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <input class="form-control" name="name" id="name" type="text"
                                       onfocus="this.placeholder = ''"
                                       onblur="this.placeholder = 'Enter your name'" placeholder="Enter your name"/>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <input class="form-control" name="email" id="email" type="email"
                                       onfocus="this.placeholder = ''"
                                       onblur="this.placeholder = 'Enter email address'"
                                       placeholder="Enter email address"/>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-group">
                                <input class="form-control" name="subject" id="subject" type="text"
                                       onfocus="this.placeholder = ''"
                                       onblur="this.placeholder = 'Enter Subject'" placeholder="Enter Subject"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group mt-3">
                        <button type="submit" class="button button-contactForm btn_4">
                            Send Message
                        </button>
                    </div>
                </form>
            </div>
            <div class="col-lg-4">
                <div class="media contact-info">
                    <span class="contact-info__icon"><i class="ti-home"></i></span>
                    <div class="media-body">
                        <h3>Buttonwood, California.</h3>
                        <p>Rosemead, CA 91770</p>
                    </div>
                </div>
                <div class="media contact-info">
                    <span class="contact-info__icon"><i class="ti-tablet"></i></span>
                    <div class="media-body">
                        <h3>00 (440) 9865 562</h3>
                        <p>Mon to Fri 9am to 6pm</p>
                    </div>
                </div>
                <div class="media contact-info">
                    <span class="contact-info__icon"><i class="ti-email"></i></span>
                    <div class="media-body">
                        <h3>support@colorlib.com</h3>
                        <p>Send us your query anytime!</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- ================ contact section end ================= -->

<!-- footer part start-->
<footer class="footer-area">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-xl-3 col-sm-6 col-md-3 col-lg-3">
                <div class="single-footer-widget footer_1">
                    <img src="resources/img/logo.png" alt="#"/>
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
<script src="resources/js/jquery-1.12.1.min.js"></script>
<!-- popper js -->
<script src="resources/js/popper.min.js"></script>
<!-- bootstrap js -->
<script src="resources/js/bootstrap.min.js"></script>
<!-- easing js -->
<script src="resources/js/jquery.magnific-popup.js"></script>
<!-- swiper js -->
<script src="resources/js/swiper.min.js"></script>
<!-- swiper js -->
<script src="resources/js/masonry.pkgd.js"></script>
<!-- particles js -->
<script src="resources/js/owl.carousel.min.js"></script>
<!-- swiper js -->
<script src="resources/js/slick.min.js"></script>
<script src="resources/js/gijgo.min.js"></script>
<script src="resources/js/jquery.nice-select.min.js"></script>
<!-- contact js -->
<script src="resources/js/contact.js"></script>
<script src="resources/js/jquery.ajaxchimp.min.js"></script>
<script src="resources/js/jquery.form.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
<script src="resources/js/mail-script.js"></script>
<!-- custom js -->
<script src="resources/js/custom.js"></script>
</body>

</html>
