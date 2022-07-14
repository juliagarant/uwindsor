#define _CRT_SECURE_NO_WARNINGS
// Visual studio gives errors on scanf without this line above.
#include <SDL2/SDL.h>
#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

// Julia Garant
// Winter 2021
// 104987469

int SCREEN_WIDTH = 800;
int SCREEN_HEIGHT = 800;

void DrawCircle(float cx, float cy, float r, int num_segments)
{
    glBegin(GL_LINE_LOOP);
    glColor3f(0.0f, 0.0f, 0.0f);
    for (int i = 0; i < num_segments; i++)
    {
        float theta = 2.0f * 3.1415926f * i / num_segments; //get the current angle
        float x = r * cosf(theta);  //calculate the x component
        float y = r * sinf(theta);  //calculate the y component
        glVertex2f(x + cx, y + cy); //output vertex
    }
    glEnd();
}

void DrawMarks()
{
    glPointSize(25);
    glBegin(GL_POINTS);
    glColor3f(0.7f, 0.0f, 1.0f);
    //when origin is 400,400
    /* glVertex2i(400, 700);   // 12
     glVertex2i(100, 400);   // 3
     glVertex2i(400, 100);   // 6
     glVertex2i(700, 400);   // 9
     */
     // when origin is 0,0
    glVertex2i(0, 300);    // 12
    glVertex2i(300, 0);    // 3
    glVertex2i(0, -300);    // 6
    glVertex2i(-300, 0);    // 9
    glEnd();
}

void Seconds(int s)
{
    glPushMatrix();
    glRotated((double)-6 * s, 0, 0, 1);
    glColor3f(1.0f, 0.0f, 0.0f);
    glLineWidth(2);
    glBegin(GL_LINES);
    glVertex2f(0, 0);
    glVertex2f(0, 320);
    glEnd();
    glPopMatrix();
}

void Minutes(int m)
{
    glPushMatrix();
    glRotated((double)-6 * m, 0, 0, 1);
    glColor3f(0.0f, 1.0f, 0.0f);
    glLineWidth(6);
    glBegin(GL_LINES);
    glVertex2f(0, 0);
    glVertex2f(0, 300);
    glEnd();
    glPopMatrix();
}

void Hours(int h, int m)
{
    glPushMatrix();
    glRotated((double)(-30 * h + m * 0.5), 0, 0, 1);
    glColor3f(0.0f, 0.0f, 1.0f);
    glLineWidth(10);
    glBegin(GL_LINES);
    glVertex2f(0, 0);
    glVertex2f(0, 200);
    glEnd();
    glPopMatrix();
}

int main(int argc, char* argv[])
{
    // Initializing SDL
    SDL_Init(SDL_INIT_EVERYTHING);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_COMPATIBILITY);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MAJOR_VERSION, 2);
    SDL_GL_SetAttribute(SDL_GL_CONTEXT_MINOR_VERSION, 1);

    // Creating SDL Window
    SDL_Window* window = SDL_CreateWindow("OpenGL", 100, 100, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_OPENGL);
    if (!window)
    {
        printf("Cannot create the sdl window: %s", SDL_GetError());
        return -1;
    }
    // Creating GL context for the window, it is required for any gl functions to work
    SDL_GLContext context = SDL_GL_CreateContext(window);
    if (!context)
    {
        printf("Cannot create OpenGL context, probably the requested version of OpenGL is not supported on your machine.");
        printf("SDL ERROR: %s", SDL_GetError());
        return -1;
    }

    // Initialize GLEW
    GLenum res = glewInit();
    if (res != 0)
    {
        printf("Cannot initialize the dynamic loading of OpenGL functions.");
        return -1;
    }
    //---------------------------------------------------------------------------------------
    // Initialize OpenGL
    glClearColor(1.0f, 1.0f, 1.0f, 0.0f); // Set clear color to white
    //glColor3f(0.0f, 0.0f, 0.0f);    // Draw in black

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, SCREEN_WIDTH, 0, SCREEN_HEIGHT, 0, 1);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    //glPointSize(4);     // Set point size
    glTranslated(400, 400, 0); // Set the origin(0,0) to the centre of the screen
    glEnable(GL_POINT_SMOOTH);      //Makes shape of points circles instead of squares

    SDL_Event windowEvent;

    while (1)
    {
        if (SDL_PollEvent(&windowEvent))
        {
            if (windowEvent.type == SDL_QUIT) break;
            if (windowEvent.type == SDL_KEYUP &&
                windowEvent.key.keysym.sym == SDLK_ESCAPE)
            {
                break;
            }
        }

        int seconds, minutes, hours;

        // Update
        {
            time_t current_time = time(NULL);
            struct tm* local_time = localtime(&current_time);
            seconds = local_time->tm_sec;
            minutes = local_time->tm_min;
            hours = local_time->tm_hour;
        }

        // Draw
        {
            glClear(GL_COLOR_BUFFER_BIT);
            glLineWidth(2);
            DrawCircle(0, 0, 325, 100);
            DrawMarks();
            Seconds(seconds);
            Minutes(minutes);
            Hours(hours, minutes);

            SDL_GL_SwapWindow(window);
        }
    }

    SDL_GL_DeleteContext(context);
    SDL_Quit();
    return 0;
}
