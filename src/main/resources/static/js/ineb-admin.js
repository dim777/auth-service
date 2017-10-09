'use strict';

var ineb_admin = angular.module('ineb_admin', [
    'ngRoute',
	'angular-md5',
	'xegexControllers'
]);

ineb_admin.config(['$routeProvider', '$locationProvider', '$httpProvider', 
    function($routeProvider, $locationProvider , $httpProvider) {
        $routeProvider.
            when('/', {
                templateUrl: 'templates/login.html',
                controller: 'LoginCtrl'
            })
            .when('/dashboard', {
                templateUrl: 'templates/dashboard.html',
                controller: 'DashboardCtrl'
            })
            .when('/config', {
                templateUrl: 'templates/config.html',
                controller: 'ConfigCtrl'
            })
            /*.when('/login', {
                templateUrl: 'templates/login.html',
                controller: 'LoginCtrl'
            })*/
            .otherwise('/');
        //$locationProvider.html5Mode(true).hashPrefix('!');
        $locationProvider.html5Mode(true);
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
		
    }]);