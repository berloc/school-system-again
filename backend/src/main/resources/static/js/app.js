'use strict';

const school_system = angular.module('school_system', [
    'ngRoute',
    'ngResource',
    'gm',
    'jcs-autoValidate'
])

    .config(['$httpProvider', '$routeProvider', '$locationProvider',
        function ($httpProvider, $routeProvider, $locationProvider) {
            $httpProvider.defaults.withCredentials = true;
            $httpProvider.defaults.headers['Content-Type'] = 'application/json; charset=UTF-8';
            $httpProvider.defaults.useXDomain = true;
            delete $httpProvider.defaults.headers.common['X-Requested-With'];
            $httpProvider.defaults.headers.post["Content-Type"] = "application/json";


            $routeProvider
                .when('/', {
                    templateUrl: 'views/home.html'
                    // controller: 'mainCtrl'
                })
                .when('/login', {
                    templateUrl: "views/login.html"
                    // controller:
                })
                .otherwise({
                redirectTo: '/'
            });
        }]);

