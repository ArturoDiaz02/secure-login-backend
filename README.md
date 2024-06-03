# Secure-Login 
## Descripción del Proyecto
Este proyecto está diseñado para proporcionar un sistema de inicio de sesión seguro que aborda las vulnerabilidades comunes de seguridad como la inyección SQL y ataques XSS. Utiliza una combinación de autenticación y autorización, implementados con Spring Security y JWT.

El sistema proporciona una capa de seguridad robusta al validar y codificar las contraseñas, asegurando que las interacciones con la base de datos estén protegidas contra la inyección de código malicioso. Además, utiliza tokens JWT para autorizar y autenticar a los usuarios, garantizando un acceso seguro a las rutas y recursos del servidor.

## Montaje del Backend
#### Requisitos
- Maven instalado
- Docker instalado
- Docker-compose instalado

#### PostMan
Puedes importar el siguiente archivo de PostMan para probar el API de este proyecto.
```json
{
  "info": {
    "_postman_id": "1f50654d-5bf5-4d80-9c0e-1db2630d16ec",
    "name": "Seguridad",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
    "_exporter_id": "24860046"
  },
  "item": [
    {
      "name": "Admin",
      "item": [
        {
          "name": "Login Admin",
          "event": [
            {
              "listen": "test",
              "script": {
                "exec": [
                  "pm.collectionVariables.set(\"ADMIN_TOKEN\",  pm.response.json().token);"
                ],
                "type": "text/javascript",
                "packages": {}
              }
            }
          ],
          "request": {
            "method": "POST",
            "header": [],
            "body": {
              "mode": "raw",
              "raw": "{\n    \"email\": \"admin@gmail.com\",\n    \"password\": \"Vamos-Madrid2023\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            },
            "url": {
              "raw": "http://localhost:8080/auth/login",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "login"
              ]
            }
          },
          "response": []
        },
        {
          "name": "Get All",
          "request": {
            "method": "GET",
            "header": [
              {
                "key": "Authorization",
                "value": "Bearer {{ADMIN_TOKEN}}"
              }
            ],
            "url": {
              "raw": "http://localhost:8080/auth/users",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "users"
              ]
            }
          },
          "response": []
        },
        {
          "name": "Count",
          "request": {
            "method": "GET",
            "header": [
              {
                "key": "Authorization",
                "value": "Bearer {{ADMIN_TOKEN}}"
              }
            ],
            "url": {
              "raw": "http://localhost:8080/auth/count",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "count"
              ]
            }
          },
          "response": []
        },
        {
          "name": "Is admin",
          "request": {
            "method": "GET",
            "header": [
              {
                "key": "Authorization",
                "value": "Bearer {{ADMIN_TOKEN}}"
              }
            ],
            "url": {
              "raw": "http://localhost:8080/auth/role",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "role"
              ]
            }
          },
          "response": []
        },
        {
          "name": "Delete user",
          "request": {
            "method": "DELETE",
            "header": [
              {
                "key": "Authorization",
                "value": "Bearer {{ADMIN_TOKEN}}"
              }
            ],
            "url": {
              "raw": "http://localhost:8080/auth/user/alex@gmail.com",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "user",
                "alex@gmail.com"
              ]
            }
          },
          "response": []
        },
        {
          "name": "Change Password",
          "request": {
            "method": "PATCH",
            "header": [
              {
                "key": "Authorization",
                "value": "Bearer {{ADMIN_TOKEN}}"
              }
            ],
            "body": {
              "mode": "raw",
              "raw": "{\n    \"email\": \"admin@gmail.com\",\n    \"oldPassword\": \"UID2ijkfsdK\",\n    \"newPassword\": \"Vamos-Madrid2023\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            },
            "url": {
              "raw": "http://localhost:8080/auth/user/changePassword",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "user",
                "changePassword"
              ]
            }
          },
          "response": []
        },
        {
          "name": "Get User",
          "request": {
            "method": "GET",
            "header": [
              {
                "key": "Authorization",
                "value": "Bearer {{ADMIN_TOKEN}}"
              }
            ],
            "url": {
              "raw": "http://localhost:8080/auth/user/alex@gmail.com",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "user",
                "alex@gmail.com"
              ]
            }
          },
          "response": []
        }
      ]
    },
    {
      "name": "User",
      "item": [
        {
          "name": "Its can",
          "item": [
            {
              "name": "Is admin",
              "request": {
                "method": "GET",
                "header": [
                  {
                    "key": "Authorization",
                    "value": "Bearer {{USER_TOKEN}}"
                  }
                ],
                "url": {
                  "raw": "http://localhost:8080/auth/role",
                  "protocol": "http",
                  "host": [
                    "localhost"
                  ],
                  "port": "8080",
                  "path": [
                    "auth",
                    "role"
                  ]
                }
              },
              "response": []
            },
            {
              "name": "Get User",
              "request": {
                "method": "GET",
                "header": [
                  {
                    "key": "Authorization",
                    "value": "Bearer {{USER_TOKEN}}"
                  }
                ],
                "url": {
                  "raw": "http://localhost:8080/auth/user/alex@gmail.com",
                  "protocol": "http",
                  "host": [
                    "localhost"
                  ],
                  "port": "8080",
                  "path": [
                    "auth",
                    "user",
                    "alex@gmail.com"
                  ]
                }
              },
              "response": []
            },
            {
              "name": "Change Password",
              "request": {
                "method": "PATCH",
                "header": [
                  {
                    "key": "Authorization",
                    "value": "Bearer {{USER_TOKEN}}"
                  }
                ],
                "body": {
                  "mode": "raw",
                  "raw": "{\n    \"email\": \"alex@gmail.com\",\n    \"oldPassword\": \"Vamos-Madrid2024\",\n    \"newPassword\": \"Vamos-Madrid2023\"\n}",
                  "options": {
                    "raw": {
                      "language": "json"
                    }
                  }
                },
                "url": {
                  "raw": "http://localhost:8080/auth/user/changePassword",
                  "protocol": "http",
                  "host": [
                    "localhost"
                  ],
                  "port": "8080",
                  "path": [
                    "auth",
                    "user",
                    "changePassword"
                  ]
                }
              },
              "response": []
            }
          ]
        },
        {
          "name": "its not can",
          "item": [
            {
              "name": "Get All",
              "request": {
                "method": "GET",
                "header": [
                  {
                    "key": "Authorization",
                    "value": "Bearer {{USER_TOKEN}}"
                  }
                ],
                "url": {
                  "raw": "http://localhost:8080/auth/users",
                  "protocol": "http",
                  "host": [
                    "localhost"
                  ],
                  "port": "8080",
                  "path": [
                    "auth",
                    "users"
                  ]
                }
              },
              "response": []
            },
            {
              "name": "Count",
              "request": {
                "method": "GET",
                "header": [
                  {
                    "key": "Authorization",
                    "value": "Bearer {{USER_TOKEN}}"
                  }
                ],
                "url": {
                  "raw": "http://localhost:8080/auth/count",
                  "protocol": "http",
                  "host": [
                    "localhost"
                  ],
                  "port": "8080",
                  "path": [
                    "auth",
                    "count"
                  ]
                }
              },
              "response": []
            },
            {
              "name": "Delete user",
              "request": {
                "method": "DELETE",
                "header": [
                  {
                    "key": "Authorization",
                    "value": "Bearer {{USER_TOKEN}}"
                  }
                ],
                "url": {
                  "raw": "http://localhost:8080/auth/user/alex@gmail.com",
                  "protocol": "http",
                  "host": [
                    "localhost"
                  ],
                  "port": "8080",
                  "path": [
                    "auth",
                    "user",
                    "alex@gmail.com"
                  ]
                }
              },
              "response": []
            }
          ]
        },
        {
          "name": "Login User",
          "event": [
            {
              "listen": "test",
              "script": {
                "exec": [
                  "pm.collectionVariables.set(\"USER_TOKEN\",  pm.response.json().token);"
                ],
                "type": "text/javascript",
                "packages": {}
              }
            }
          ],
          "request": {
            "method": "POST",
            "header": [],
            "body": {
              "mode": "raw",
              "raw": "{\n    \"email\": \"alex@gmail.com\",\n    \"password\": \"Vamos-Madrid2023\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            },
            "url": {
              "raw": "http://localhost:8080/auth/login",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "login"
              ]
            }
          },
          "response": []
        },
        {
          "name": "Signup",
          "event": [
            {
              "listen": "test",
              "script": {
                "exec": [
                  "pm.collectionVariables.set(\"USER_TOKEN\",  pm.response.json().token);"
                ],
                "type": "text/javascript",
                "packages": {}
              }
            }
          ],
          "request": {
            "method": "POST",
            "header": [],
            "body": {
              "mode": "raw",
              "raw": "{\n    \"firstName\": \"Alex\",\n    \"lastName\": \"Sanchez\",\n    \"email\": \"alex@gmail.com\",\n    \"password\": \"Vamos-Madrid2024\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            },
            "url": {
              "raw": "http://localhost:8080/auth/signup",
              "protocol": "http",
              "host": [
                "localhost"
              ],
              "port": "8080",
              "path": [
                "auth",
                "signup"
              ]
            }
          },
          "response": []
        }
      ]
    }
  ],
  "event": [
    {
      "listen": "prerequest",
      "script": {
        "type": "text/javascript",
        "packages": {},
        "exec": [
          ""
        ]
      }
    },
    {
      "listen": "test",
      "script": {
        "type": "text/javascript",
        "packages": {},
        "exec": [
          ""
        ]
      }
    }
  ],
  "variable": [
    {
      "key": "ADMIN_TOKEN",
      "value": "init",
      "type": "string"
    },
    {
      "key": "USER_TOKEN",
      "value": "init",
      "type": "string"
    }
  ]
}
```

### Pasos:
1. Clona el repositorio del backend.
2. Entra en el directorio raíz del proyecto.
3. Ejecuta el comando `docker-compose up -d` para iniciar el proyecto.

## Realización del proyecto
Este programa se realizó usando Java Springboot y una base de datos PostgreSQL. Al momento de tener en cuenta lo que podría significar que un login fuera seguro, implementamos en el proyecto medidas especialmente para la autenticación y autorización de usuarios y la encriptación de contraseñas para proteger la integridad de los mismos en caso de brechas.

Adicionalmente, se aplicó sanitización de inputs para disminuir la posibilidad de ataques de inyección sql y cross-site scripting (xss) que, junto al sistema basado en roles que se implementó, permite tener distintas capas de seguridad para este login.

## Dificultades del proyecto
Las principales dificultades del proyecto se agrupan en 3 categorías:
1. Desarrollo del encriptador de contraseñas 
2. Implementación de JWT y sus pasos de seguridad
3. Aplicación de roles y sanitización de Inputs.

En cada categoría, hubo un proceso de entendimiento y de desarrollo en aspectos que no se habían tenido en cuenta en ocasiones pasadas, lo que llevó a ciertas dificultades, errores y bugs en los que el código no funcionaba como debía o no funcionaba como necesitabamos.

Estos problemas llevaron a tener en cuenta distintas opciones, de poder usar diferentes librerias y de investigar cuales eran las mejores prácticas para poder mantener la seguridad en el sistema de login.

## Conclusiones
El proyecto Secure-Login representa un esfuerzo significativo para crear un sistema de inicio de sesión seguro y robusto. A través de la implementación de tecnologías como Spring Security, JWT, y prácticas de cifrado de contraseñas, hemos logrado abordar las principales vulnerabilidades de seguridad como la inyección SQL y los ataques XSS.

Durante el desarrollo, enfrentamos desafíos significativos, particularmente en la gestión y aplicación efectiva de las prácticas de seguridad en el manejo de contraseñas y la implementación adecuada de JWT para la autenticación y autorización. Estos obstáculos nos permitieron comprender la importancia de la seguridad en cada etapa del desarrollo de aplicaciones web.

El enfoque en la sanidad de entradas, el manejo de roles y los protocolos de seguridad nos brindó una comprensión más profunda de las mejores prácticas en seguridad de aplicaciones y cómo usarlas de manera efectiva en un proyecto real.

En conclusión, Secure-Login no solo representa un sistema de inicio de sesión seguro, sino también un aprendizaje valioso sobre la importancia de la seguridad en el desarrollo de software y la aplicación práctica de técnicas de protección contra vulnerabilidades comunes.

## Generalidades Finales del Proyecto y Contribuciones
El proyecto se mantiene abierto a contribuciones externas que puedan mejorar aún más la seguridad, la eficiencia y la funcionalidad del sistema. Se alienta a cualquier persona interesada en la seguridad informática y el desarrollo de aplicaciones web a contribuir con mejoras, correcciones de errores o nuevas funcionalidades a través de solicitudes de extracción (pull requests). ¡Todas las contribuciones son bienvenidas!

No dudes en adaptar y agregar más detalles o reflexiones específicas que consideres relevantes para el proyecto.