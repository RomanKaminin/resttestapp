

Для проверки работы приложения у вас должен быть установлен "docker-compose"

    docker-compose build
    docker-compose up --remove-orphans
    docker-compose run --rm django_project python ./manage.py createsuperuser --email admin@example.com --username admin
    после старта докера приложение будет доступно http://127.0.0.1:8080/api/order
    для тестирования использовать любой HTTP-клиент, например Postman

