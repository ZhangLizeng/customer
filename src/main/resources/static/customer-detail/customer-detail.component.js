'use strict';

// Register `phoneDetail` component, along with its associated controller and template
angular.
  module('customerDetail').
  component('customerDetail', {
    templateUrl: 'customer-detail/customer-detail.template.html',
    controller: ['$routeParams', 'Customer', 'Note',
      function CustomerDetailController($routeParams, Customer, Note) {
        var self = this;
        self.customer = Customer.get({customerId: $routeParams.customerId});

        self.notes = Note.query({customerId: $routeParams.customerId});

        self.updateStatus = function updateStatus(status) {
          Customer.updateStatus({customerId: $routeParams.customerId, status: status}, {})
        };

        self.updateNote = function updateNote(a, b, c) {
          Note.updateNote({customerId: a, noteId: b, newNote: c}, {}, function() {
            self.notes = Note.query({customerId: $routeParams.customerId});
          });
        };

        self.addNote = function addNote(a, b) {
          Note.addNote({customerId: a, noteString: b}, {}, function() {
            self.notes = Note.query({customerId: $routeParams.customerId});
            self.newNote = "";
          });
        };
      }
    ]
  });
