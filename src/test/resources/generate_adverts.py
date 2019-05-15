import base64
import json
import random

with open('data.json', 'r') as f:
    data = json.load(f)

types = ['собака', 'кошка']
names = {1: ['Мурка', 'Буська', 'Слонька', 'Манька', 'Рыжуха', 'Пуська', 'Барсик'],
         0: ['Шарик', 'Бобик', 'Дружок', 'Фредди', 'Тайсон', 'Мопсик', 'Носик']}
breeds = {1: ['Персидская', 'Голубая', 'Манул', 'Камышовая', 'Метис', 'Ориентал'],
          0: ['Терьер', 'Лабрадор', 'Корги', 'Овчарка', 'Доберман', 'Хаски', 'Самоед']}
colors = ['Светло-коричневая', 'Черная', 'Белая', 'Рыжая', 'Камышовая', 'Коричневая', 'Пятнистая']

for i in range(100):
    is_cat = random.randint(0, 1)
    type_ = types[is_cat]
    name = names[is_cat][random.randint(0, 1)]
    field = dict()
    field['id'] = i
    field['title'] = 'Пропала {} по кличке {}'.format(type_, name)
    field['description'] = 'Пропала {}, нашедших просьба позвонить по телефону {}, помогите найти!!!'.format(type_,
                                                                                                             str(
                                                                                                                 random.randint(
                                                                                                                     60000,
                                                                                                                     69999)))
    field['name'] = name

    image = open('imgs/{}/{}.jpg'.format(['cats/', 'dogs/'][is_cat], str(random.randint(0, 4))), 'rb')
    image_read = image.read()
    # image_64_encode = base64.encodestring(image_read)
    base64_bytes = base64.b64encode(image_read)
    base64_string = base64_bytes.decode('utf-8')
    field['image'] = base64_string
    image.close()
    # field['image'] = 1

    field['breed'] = breeds[is_cat][random.randint(0, 1)]
    field['vaccinations'] = bool(random.randint(0, 1))
    field['height'] = round(random.random() * 2, 2)
    field['weight'] = round(random.random() * 12, 2)
    field['coatColor'] = colors[random.randint(0, 1)]
    data.append(field)

with open('data.json', 'w') as f:
    json.dump(data, f)
