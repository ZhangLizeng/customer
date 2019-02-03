'use strict';

angular.
  module('core.customer').
  factory('Customer', ['$resource',
    function($resource) {
      return $resource('api/customers/:customerId', {}, {
        query: {
          method: 'GET',
          isArray: true
        },
        updateStatus: {
          method: 'PUT'
        },
        addCustomer: {
          method: 'POST'
        }
      });
    }
  ]).
  factory('Note', ['$resource',
    function($resource) {
      return $resource('api/customers/:customerId/notes/:noteId', {}, {
        query: {
          method: 'GET',
          isArray: true
        },
        updateNote: {
          method: 'PUT'
        },
        addNote: {
          method: 'POST'
        }
      });
    }
  ]);
