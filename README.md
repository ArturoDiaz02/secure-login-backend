﻿# Secure-Login 
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

### Dificultades del proyecto

A lo largo del desarrollo del sistema de login seguro, se presentaron varios retos significativos. En primer lugar, asegurar que la gestión de nombres de usuario y contraseñas se hiciera de manera segura fue un desafío. Implementar una única cuenta de administrador con permisos especiales para consultar, eliminar o restablecer contraseñas de usuarios, y al mismo tiempo garantizar la seguridad de estas operaciones, requirió un cuidadoso diseño exhaustivo.

Otro obstáculo fue la implementación del algoritmo PBKDF2 para el hashing de contraseñas. Este algoritmo, aunque altamente recomendado para mejorar la seguridad, demandó un entendimiento profundo de su funcionamiento y la correcta integración en el sistema. Además, garantizar que las contraseñas se almacenaran de manera segura con salt en un archivo de texto o base de datos implicó investigar y adaptar técnicas criptográficas avanzadas.

Por último, asegurar que los usuarios comunes pudieran consultar su última fecha y hora de login y cambiar sus contraseñas sin comprometer la seguridad del sistema añadió una capa adicional de complejidad. La necesidad de equilibrar facilidad de uso con robustez en seguridad fue un constante reto durante todo el proyecto.

### Conclusiones

El desarrollo del sistema de login seguro en Java con Spring Boot nos permitió adquirir valiosas lecciones sobre la implementación de medidas de seguridad en aplicaciones web. Logramos diseñar una solución que no solo permite una gestión efectiva de usuarios y contraseñas, sino que también garantiza altos estándares de seguridad a través del uso de algoritmos de hashing y técnicas de almacenamiento seguras.

La implementación de una cuenta de administrador con capacidades específicas y el manejo seguro de las operaciones relacionadas con usuarios han demostrado ser elementos clave para mantener la integridad y seguridad del sistema. Además, la utilización de PBKDF2 para el hashing de contraseñas ha fortalecido significativamente la protección de los datos de los usuarios.

En conclusión, a pesar de los desafíos enfrentados, el proyecto resultó en una aplicación robusta y segura que cumple con los requisitos funcionales y de seguridad propuestos. Esta experiencia subraya la importancia de incorporar prácticas de seguridad desde las etapas iniciales del desarrollo y nos prepara para afrontar proyectos futuros con una base sólida en seguridad informática.
