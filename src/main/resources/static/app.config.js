'use strict';

angular.
  module('customerApp').
  config(['$routeProvider',
    function config($routeProvider) {
      $routeProvider.
        when('/customers', {
          template: '<customer-list></customer-list>'
        }).
        when('/customers/:customerId', {
          template: '<customer-detail></customer-detail>'
        }).
        otherwise('/customers');
    }
  ]);
