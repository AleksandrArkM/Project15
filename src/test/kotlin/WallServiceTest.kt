import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    @Test
    fun addNewPost() {
        val expectedId = 2
        val service = WallService()
        val newPost = service.add(Post(2, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true));
        assertEquals(newPost.id, expectedId)
    }

    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(2, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true));
        service.add(Post(3, 666, "Yes yes", 25, false, true, Comment(2, 222, "nice comment!!", 0), true));
        service.add(Post(4, 777, "Hello all", 26, true, true, Comment(3, 333, "nice comment", 0), true));
        val update = Post(2, 999, "Yes and not now", 27, false, true, Comment(1, 111, "nice comment", 0), true)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        // создаём целевой сервис
        val service = WallService()
        // заполняем несколькими постами
        service.add(Post(111, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true));
        service.add(Post(112, 666, "Yes yes", 25, false, true, Comment(2, 222, "nice comment!!", 0), true));
        service.add(Post(113, 777, "Hello all", 26, true, true, Comment(3, 333, "nice comment", 0), true));
        val update = Post(114, 999, "Yes and not now", 27, false, true, Comment(1, 111, "nice comment", 0), true)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }
}