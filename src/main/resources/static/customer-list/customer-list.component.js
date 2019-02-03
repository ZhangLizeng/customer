'use strict';

// Register `phoneList` component, along with its associated controller and template
angular.
  module('customerList').
  component('customerList', {
    templateUrl: 'customer-list/customer-list.template.html',
    controller: ['Customer',
      function CustomerListController(Customer) {
        var self = this;
        this.customers = Customer.query();
        this.orderProp = 'firstName';

        this.addCustomer = function addCustomer(firstName, lastName) {
          Customer.addCustomer({firstName: firstName, lastName: lastName}, {}, function() {
            self.customers = Customer.query();
            self.firstName = "";
            self.lastName = "";
          });
        }
      }
    ]
  });
