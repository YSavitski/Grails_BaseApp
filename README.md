# Grails_BaseApp

Application uses imbadable database.

Created by default:
  -2 users (user:user, admin:admin)
  -2 roles (ROLE_USER, ROLE_ADMIN)
  -2 clients with their geolocations

User with role "ROLE_USER" (user) may only view list of client and forvard to selected client
User with role "ROLE_ADMIN" (admin) has functional from role (ROLE_USER) and more:
  - may upload .csv file with client in format (name, email, street, zip). (Clients.csv in root of project) 
  - may create new, edit existence, delete clients
  - may create users 
